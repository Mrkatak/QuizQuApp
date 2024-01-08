package com.example.quizquapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val dataList: List<DataItem>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>(){

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val icon: ImageView = view.findViewById(R.id.ic_RvIcon)
            val judul: TextView = view.findViewById(R.id.tv_Judul)
            val subJudul: TextView = view.findViewById(R.id.tv_subJudul)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = dataList[position]
        holder.icon.setImageResource(dataItem.icon)
        holder.judul.text = dataItem.judul
        holder.subJudul.text = dataItem.subjudul

    }

    override fun getItemCount() = dataList.size
}