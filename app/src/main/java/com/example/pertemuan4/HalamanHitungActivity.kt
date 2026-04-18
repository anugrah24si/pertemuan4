package com.example.pertemuan4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * Activity untuk menangani proses perhitungan Luas dan Keliling Bangun Datar.
 * Halaman ini bersifat dinamis, tampilannya akan berubah tergantung pada jenis bangun yang dipilih.
 */
class HalamanHitungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menentukan file layout XML yang akan ditampilkan di layar
        setContentView(R.layout.activity_halaman_hitung)

        // --- INISIALISASI KOMPONEN UI ---
        // Menghubungkan variabel di kode dengan elemen UI yang ada di XML berdasarkan ID
        val tvJudul = findViewById<TextView>(R.id.tvJudulHitung)
        val tilInput1 = findViewById<TextInputLayout>(R.id.tilInput1)
        val tilInput2 = findViewById<TextInputLayout>(R.id.tilInput2)
        val etInput1 = findViewById<TextInputEditText>(R.id.etInput1)
        val etInput2 = findViewById<TextInputEditText>(R.id.etInput2)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val btnKembali = findViewById<Button>(R.id.btnKembali)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // --- MENGAMBIL DATA DARI INTENT ---
        // Mengambil data "BANGUN_DATAR" yang dikirim dari HalamanInformasiActivity
        val jenisBangun = intent.getStringExtra("BANGUN_DATAR")

        // --- KONFIGURASI TAMPILAN SESUAI JENIS BANGUN ---
        // Jika pengguna memilih Persegi
        if (jenisBangun == "persegi") {
            tvJudul.text = "Hitung Persegi"
            tilInput1.hint = "Masukkan Sisi (cm)"
            // Sembunyikan input kedua karena persegi hanya butuh satu nilai sisi
            tilInput2.visibility = View.GONE 
        } 
        // Jika pengguna memilih Segitiga
        else if (jenisBangun == "segitiga") {
            tvJudul.text = "Hitung Segitiga"
            tilInput1.hint = "Masukkan Alas (cm)"
            tilInput2.hint = "Masukkan Tinggi (cm)"
            // Tampilkan input kedua untuk mengisi nilai tinggi segitiga
            tilInput2.visibility = View.VISIBLE 
        }

        // --- LOGIKA TOMBOL HITUNG ---
        btnHitung.setOnClickListener {
            // Mengambil input teks dari EditText
            val s1 = etInput1.text.toString()
            val s2 = etInput2.text.toString()

            // Validasi: Pastikan input tidak kosong sesuai jenis bangunnya
            if (s1.isEmpty() || (jenisBangun == "segitiga" && s2.isEmpty())) {
                Toast.makeText(this, "Mohon isi semua data input!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Berhenti jika ada data yang kosong
            }

            try {
                // Mengubah input teks menjadi angka desimal (Double)
                val val1 = s1.toDouble()

                // Proses hitung jika jenisnya Persegi
                if (jenisBangun == "persegi") {
                    val luas = val1 * val1
                    val keliling = 4 * val1
                    
                    // Menampilkan hasil perhitungan ke TextView
                    tvHasil.text = "Hasil Persegi:\nLuas: $luas cm²\nKeliling: $keliling cm"
                } 
                // Proses hitung jika jenisnya Segitiga
                else if (jenisBangun == "segitiga") {
                    val val2 = s2.toDouble()
                    // Rumus Luas Segitiga: 1/2 * alas * tinggi
                    val luas = 0.5 * val1 * val2
                    
                    // Menghitung sisi miring dan keliling (asumsi segitiga siku-siku)
                    val miring = Math.sqrt((val1 * val1) + (val2 * val2))
                    val keliling = val1 + val2 + miring
                    
                    // Menampilkan hasil dengan format 2 angka di belakang koma untuk keliling
                    tvHasil.text = "Hasil Segitiga:\nLuas: $luas cm²\nKeliling (Siku-siku): ${String.format("%.2f", keliling)} cm"
                }
            } catch (e: Exception) {
                // Menangani error jika input yang dimasukkan bukan angka yang valid
                Toast.makeText(this, "Masukkan angka yang valid!", Toast.LENGTH_SHORT).show()
            }
        }

        // --- LOGIKA TOMBOL KEMBALI ---
        btnKembali.setOnClickListener {
            // Menutup activity ini dan kembali ke halaman sebelumnya
            finish()
        }
    }
}