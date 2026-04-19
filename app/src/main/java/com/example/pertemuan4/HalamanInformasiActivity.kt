package com.example.pertemuan4

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity Informasi Bangun Datar.
 * Sesuai permintaan: Hanya menampilkan informasi rumus tanpa fungsi navigasi ke perhitungan.
 */
class HalamanInformasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_informasi)

        // --- KOMENTAR PENJELASAN ---
        // Karena fitur ini sekarang hanya untuk melihat informasi, 
        // tombol "Pilih & Hitung" di XML telah disembunyikan (android:visibility="gone").
        // Klik pada Card juga sudah tidak lagi diarahkan ke halaman hitung.

        // Tombol Kembali ke Dashboard
        val btnKembali = findViewById<Button>(R.id.btnKembaliDashboard)
        btnKembali.setOnClickListener {
            // Fungsi: Menutup halaman ini untuk kembali ke menu utama
            finish()
        }
    }
}