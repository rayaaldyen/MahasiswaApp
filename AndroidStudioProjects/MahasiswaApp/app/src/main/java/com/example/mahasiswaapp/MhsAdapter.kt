package com.example.mahasiswaapp
import java.util.*
import kotlin.collections.ArrayList
import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class MhsAdapter(private val context:Context, private val listener: ITodoAdapter): RecyclerView.Adapter<MhsAdapter.MhsViewHolder>() {
    private val listMhs = ArrayList<MhsModel>()

    inner class MhsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNama:TextView = itemView.findViewById<TextView>(R.id.tv_nama)
        val textViewNim:TextView = itemView.findViewById<TextView>(R.id.tv_nim)
        val textViewKelas:TextView = itemView.findViewById<TextView>(R.id.tv_kelas)
        val deleteButton:ImageView = itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MhsViewHolder {
        val view =
            MhsViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
        view.deleteButton.setOnClickListener {
            listener.onItemClicked(listMhs[view.adapterPosition])
        }
        return view
    }

    override fun onBindViewHolder(holder: MhsViewHolder, position: Int) {
        val currentList = listMhs[position]
        holder.textViewNama.text = currentList.nama
        holder.textViewNim.text = currentList.nim
        holder.textViewKelas.text = currentList.kelas

    }

    override fun getItemCount(): Int {
        return listMhs.size
    }
    fun updateList(listBaru: List<MhsModel>){
        listMhs.clear()
        listMhs.addAll(listBaru)
        notifyDataSetChanged()
    }
    interface ITodoAdapter{
        fun onItemClicked(mhs:MhsModel)
    }
}