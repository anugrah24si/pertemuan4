package com.example.pertemuan4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class HalamanInformasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_informasi)

        // Kita bisa membuat card-nya juga bisa diklik untuk pengalaman yang lebih baik
        val cardPersegi = findViewById<MaterialCardView>(R.id.cardPersegi)
        val cardSegitiga = findViewById<MaterialCardView>(R.id.cardSegitiga)
        val btnPersegi = findViewById<Button>(R.id.btnHitungPersegi)
        val btnSegitiga = findViewById<Button>(R.id.btnHitungSegitiga)

        // Fungsi navigasi ke halaman hitung
        fun navigasiKeHitung(bangun: String) {
            val intent = Intent(this, HalamanHitungActivity::class.java)
            intent.putExtra("BANGUN_DATAR", bangun)
            startActivity(intent)
        }

        // Event Klik untuk Persegi
        cardPersegi.setOnClickListener { navigasiKeHitung("persegi") }
        btnPersegi.setOnClickListener { navigasiKeHitung("persegi") }

        // Event Klik untuk Segitiga
        cardSegitiga.setOnClickListener { navigasiKeHitung("segitiga") }
        btnSegitiga.setOnClickListener { navigasiKeHitung("segitiga") }

        // Tambahkan tombol kembali ke Dashboard
        val btnKembali = findViewById<Button>(R.id.btnKembaliDashboard)
        btnKembali.setOnClickListener {
            finish()
        }
    }
}