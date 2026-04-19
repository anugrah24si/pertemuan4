package com.example.pertemuan4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * Activity untuk menangani proses perhitungan Luas dan Keliling Bangun Datar.
 * Pengguna dapat memilih jenis bangun (Persegi/Segitiga) menggunakan RadioGroup.
 */
class HalamanHitungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_hitung)

        // --- INISIALISASI KOMPONEN UI ---
        val tvJudul = findViewById<TextView>(R.id.tvJudulHitung)
        val rgPilihan = findViewById<RadioGroup>(R.id.rgPilihanBangun)
        val tilInput1 = findViewById<TextInputLayout>(R.id.tilInput1)
        val tilInput2 = findViewById<TextInputLayout>(R.id.tilInput2)
        val etInput1 = findViewById<TextInputEditText>(R.id.etInput1)
        val etInput2 = findViewById<TextInputEditText>(R.id.etInput2)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val btnKembali = findViewById<Button>(R.id.btnKembali)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // --- LOGIKA PERUBAHAN PILIHAN BANGUN (RadioGroup) ---
        rgPilihan.setOnCheckedChangeListener { _, checkedId ->
            // Bersihkan data saat mengganti jenis bangun
            tvHasil.text = "Hasil akan tampil di sini"
            etInput1.text?.clear()
            etInput2.text?.clear()

            if (checkedId == R.id.rbPersegi) {
                // Konfigurasi untuk Persegi
                tvJudul.text = "Hitung Persegi"
                tilInput1.hint = "Masukkan Sisi (cm)"
                tilInput2.visibility = View.GONE // Sembunyikan input kedua
            } else {
                // Konfigurasi untuk Segitiga
                tvJudul.text = "Hitung Segitiga"
                tilInput1.hint = "Masukkan Alas (cm)"
                tilInput2.hint = "Masukkan Tinggi (cm)"
                tilInput2.visibility = View.VISIBLE // Tampilkan input kedua
            }
        }

        // --- LOGIKA TOMBOL HITUNG ---
        // Fungsi ini dipicu saat pengguna menekan tombol "HITUNG SEKARANG"
        btnHitung.setOnClickListener {
            val s1 = etInput1.text.toString()
            val s2 = etInput2.text.toString()
            val isPersegi = rgPilihan.checkedRadioButtonId == R.id.rbPersegi

            // 1. Validasi Input: Memastikan semua kolom yang dibutuhkan sudah terisi
            if (s1.isEmpty() || (!isPersegi && s2.isEmpty())) {
                Toast.makeText(this, "Mohon isi semua data input!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                // 2. Konversi Input: Mengubah teks menjadi angka desimal (Double)
                val val1 = s1.toDouble()

                if (isPersegi) {
                    // --- PERHITUNGAN PERSEGI ---
                    // Rumus: Luas = Sisi * Sisi, Keliling = 4 * Sisi
                    val luas = val1 * val1
                    val keliling = 4 * val1

                    // Menampilkan hasil perhitungan ke layar
                    tvHasil.text = "Hasil Persegi:\nLuas: $luas cm²\nKeliling: $keliling cm"
                } else {
                    // --- PERHITUNGAN SEGITIGA ---
                    // Rumus: Luas = 0.5 * Alas * Tinggi
                    val val2 = s2.toDouble()
                    val luas = 0.5 * val1 * val2

                    // Menghitung sisi miring & keliling (asumsi segitiga siku-siku)
                    val miring = Math.sqrt((val1 * val1) + (val2 * val2))
                    val keliling = val1 + val2 + miring

                    // Menampilkan hasil dengan pembulatan 2 angka di belakang koma untuk keliling
                    tvHasil.text = "Hasil Segitiga:\nLuas: $luas cm²\nKeliling (Siku-siku): ${String.format("%.2f", keliling)} cm"
                }
            } catch (e: Exception) {
                // Menangani jika user memasukkan karakter yang bukan angka
                Toast.makeText(this, "Masukkan angka yang valid!", Toast.LENGTH_SHORT).show()
            }
        }

        // --- TOMBOL KEMBALI ---
        btnKembali.setOnClickListener {
            // Fungsi: Menutup halaman kalkulator dan kembali ke Dashboard
            finish()
        }
    }
}