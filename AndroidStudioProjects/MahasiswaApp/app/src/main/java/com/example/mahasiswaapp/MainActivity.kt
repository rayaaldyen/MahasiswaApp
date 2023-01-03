package com.example.mahasiswaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), MhsAdapter.ITodoAdapter {
    private lateinit var viewModel:MhsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_mhs.layoutManager = LinearLayoutManager(this)
        val adapter = MhsAdapter(this, this)
        rv_mhs.adapter=adapter
        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MhsViewModel::class.java)
        viewModel.listHms.observe(this, Observer { list -> list?.let {
                adapter.updateList(it)
            }

        }
        )
    }

    override fun onItemClicked(mhs: MhsModel) {
        viewModel.deleteMhs(mhs)
        Toast.makeText(this, "${mhs.nama} Dihapus", Toast.LENGTH_LONG).show()
    }
    fun submitData(view: View){
        val namaText= findViewById<TextView>(R.id.nama).text.toString()
        val nimText= findViewById<TextView>(R.id.nim).text.toString()
        val kelastext= findViewById<TextView>(R.id.kelas).text.toString()
        if(namaText.isNotEmpty() && nimText.isNotEmpty() && kelastext.isNotEmpty()){
            viewModel.insertMhs(MhsModel(namaText,nimText,kelastext))
            Toast.makeText(this, "$namaText Ditambahkan", Toast.LENGTH_LONG).show()
        }
    }
}