package com.example.mahasiswaapp
import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.AndroidViewModel


class MhsViewModel(application: Application): AndroidViewModel(application) {
    private val repository :MhsRepository
    val listHms : LiveData<List<MhsModel>>

    init {
        val dao =MhsDatabase.getDatabase(application).getMhsDao()
        repository = MhsRepository(dao)
        listHms = repository.listMhs
    }

    fun deleteMhs(mhs: MhsModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(mhs)

    }
    fun insertMhs(mhs: MhsModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(mhs)


    }



}