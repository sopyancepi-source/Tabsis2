package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "siswa")
data class Siswa(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nama: String,
    val kelas: String,
    val nomorInduk: String,
    val tanggalDaftar: Long = System.currentTimeMillis()
)

@Entity(tableName = "transaksi")
data class Transaksi(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val siswaId: Int, // Menghubungkan ke Siswa.id
    val tipe: String, // "SETOR" atau "TARIK"
    val jumlah: Double,
    val biayaAdmin: Double = 0.0, // Biaya admin opsional
    val tanggal: Long = System.currentTimeMillis(),
    val keterangan: String = ""
)

@Entity(tableName = "pinjaman_sekolah")
data class PinjamanSekolah(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val deskripsi: String,
    val jumlahPinjam: Double,
    val jumlahBayar: Double = 0.0, // Jumlah yang sudah dibayar/dilunasi
    val tanggalPinjam: Long = System.currentTimeMillis(),
    val tanggalLunas: Long? = null,
    val lunas: Boolean = false
)

@Entity(tableName = "pinjaman_guru")
data class PinjamanGuru(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val namaGuru: String,
    val jumlahPinjam: Double,
    val jumlahBayar: Double = 0.0, // Jumlah yang sudah dibayar/dilunasi
    val tanggalPinjam: Long = System.currentTimeMillis(),
    val tanggalLunas: Long? = null,
    val lunas: Boolean = false
)

@Entity(tableName = "admin_kas")
data class AdminKas(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tipe: String, // "MODAL_AWAL", "PENDAPATAN_ADMIN", "PENGELUARAN_OPERASIONAL"
    val jumlah: Double,
    val tanggal: Long = System.currentTimeMillis(),
    val keterangan: String = ""
)

@Entity(tableName = "setor_koperasi")
data class SetorKoperasi(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val jumlah: Double,
    val penerima: String,
    val tanggal: Long = System.currentTimeMillis(),
    val ttdOnline: String? = null // Serialized coordinate points base representation
)
