package com.example.mahasiswaapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MhsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(mhs: MhsModel)

    @Delete
    fun delete(mhs: MhsModel)
    @Query("Select * from daftar_mahasiswa order by id ASC")
    fun getListMhs(): LiveData<List<MhsModel>>
}