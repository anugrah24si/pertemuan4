package com.example.pertemuan4

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HalamanProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_profile)

        val btnKembali = findViewById<Button>(R.id.btnKembaliDashboard)

        btnKembali.setOnClickListener {
            // Kembali ke Dashboard (Activity sebelumnya)
            finish()
        }
    }
}