package com.example.pertemuan4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Langsung pindah ke HalamanInformasiActivity
        val intent = Intent(this, HalamanInformasiActivity::class.java)
        startActivity(intent)
        finish() // Menutup MainActivity agar tidak bisa kembali ke sini
    }
}