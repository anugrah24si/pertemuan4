package com.example.pertemuan4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnInformasi = findViewById<Button>(R.id.btnNavInformasi)
        val btnHitung = findViewById<Button>(R.id.btnNavHitung)
        val btnProfile = findViewById<Button>(R.id.btnNavProfile)

        btnInformasi.setOnClickListener {
            val intent = Intent(this, HalamanInformasiActivity::class.java)
            startActivity(intent)
        }

        btnHitung.setOnClickListener {
            val intent = Intent(this, HalamanHitungActivity::class.java)
            // Default ke persegi jika lewat dashboard, atau bisa disesuaikan
            intent.putExtra("BANGUN_DATAR", "persegi") 
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(this, HalamanProfileActivity::class.java)
            startActivity(intent)
        }
    }
}