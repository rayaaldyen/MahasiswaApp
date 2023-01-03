package com.example.mahasiswaapp
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daftar_mahasiswa")
class MhsModel(@ColumnInfo(name = "nama") var nama: String, @ColumnInfo(name = "nim") var nim: String, @ColumnInfo(name = "kelas") var kelas: String){
    @PrimaryKey(autoGenerate = true) var id = 0

}