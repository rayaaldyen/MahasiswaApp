package com.example.mahasiswaapp
import androidx.lifecycle.LiveData

class MhsRepository(private val mhsDao: MhsDao) {
    val listMhs: LiveData<List<MhsModel>> = mhsDao.getListMhs()
    suspend fun insert(mhs: MhsModel){
        mhsDao.insert((mhs))
    }
    suspend fun delete(mhs: MhsModel){
        mhsDao.delete((mhs))
    }
}