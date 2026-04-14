package com.example.pertemuan4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class HalamanHitungActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_hitung)

        val tvJudul = findViewById<TextView>(R.id.tvJudulHitung)
        val tilInput1 = findViewById<TextInputLayout>(R.id.tilInput1)
        val tilInput2 = findViewById<TextInputLayout>(R.id.tilInput2)
        val etInput1 = findViewById<TextInputEditText>(R.id.etInput1)
        val etInput2 = findViewById<TextInputEditText>(R.id.etInput2)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val btnKembali = findViewById<Button>(R.id.btnKembali)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // Mengambil data intent
        val jenisBangun = intent.getStringExtra("BANGUN_DATAR")

        // Konfigurasi tampilan berdasarkan jenis bangun
        if (jenisBangun == "persegi") {
            tvJudul.text = "Hitung Persegi"
            tilInput1.hint = "Sisi (cm)"
            tilInput2.visibility = View.GONE
        } else {
            tvJudul.text = "Hitung Segitiga"
            tilInput1.hint = "Alas (cm)"
            tilInput2.hint = "Tinggi (cm)"
            tilInput2.visibility = View.VISIBLE
        }

        btnHitung.setOnClickListener {
            val s1 = etInput1.text.toString()
            val s2 = etInput2.text.toString()

            if (s1.isEmpty() || (jenisBangun == "segitiga" && s2.isEmpty())) {
                Toast.makeText(this, "Mohon isi semua input!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val num1 = s1.toDouble()
                if (jenisBangun == "persegi") {
                    val luas = num1 * num1
                    val keliling = 4 * num1
                    tvHasil.text = "Hasil Persegi:\nLuas: $luas cm²\nKeliling: $keliling cm"
                } else {
                    val num2 = s2.toDouble()
                    val luas = 0.5 * num1 * num2
                    tvHasil.text = "Hasil Segitiga:\nLuas: $luas cm²"
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Input tidak valid!", Toast.LENGTH_SHORT).show()
            }
        }

        // Fitur balik ke pemilihan bangun datar
        btnKembali.setOnClickListener {
            finish() // Menutup activity ini dan kembali ke activity sebelumnya (HalamanInformasi)
        }
    }
}