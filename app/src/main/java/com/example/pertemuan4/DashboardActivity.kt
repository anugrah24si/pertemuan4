package com.example.pertemuan4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity Dashboard sebagai menu utama aplikasi.
 * Menghubungkan pengguna ke berbagai fitur: Informasi Bangun Datar, Perhitungan, dan Profil.
 */
class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menampilkan layout dashboard
        setContentView(R.layout.activity_dashboard)

        // --- INISIALISASI TOMBOL NAVIGASI ---
        val btnInformasi = findViewById<Button>(R.id.btnNavInformasi)
        val btnHitung = findViewById<Button>(R.id.btnNavHitung)
        val btnProfile = findViewById<Button>(R.id.btnNavProfile)

        // --- LOGIKA KLIK TOMBOL ---

        // Fungsi: Membuka Halaman Informasi Bangun Datar (Hanya Rumus)
        btnInformasi.setOnClickListener {
            val intent = Intent(this, HalamanInformasiActivity::class.java)
            startActivity(intent)
        }

        // Fungsi: Membuka Halaman Kalkulator Hitung Bangun Datar
        // Pengguna bisa memilih Persegi atau Segitiga langsung di dalam halaman ini.
        btnHitung.setOnClickListener {
            val intent = Intent(this, HalamanHitungActivity::class.java)
            startActivity(intent)
        }

        // Fungsi: Membuka Halaman Profil Pengembang
        btnProfile.setOnClickListener {
            val intent = Intent(this, HalamanProfileActivity::class.java)
            startActivity(intent)
        }
    }
}