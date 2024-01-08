package com.example.quizquapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NoteFragment : Fragment() {

    private lateinit var dataAdapter: DataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycleView)
        val dataList = listOf(
            DataItem(1, R.drawable.ic_iot, "Perkembangan AI", getString(R.string.SubJudul1)),
            DataItem(2, R.drawable.ic_iot, "Data Science On Fire", "Gaji data Science sangat tinggi"),
            DataItem(3, R.drawable.ic_iot, "Sistem Operasi Mobile Baru", "Harmony OS buatan Huawei")
        )

        dataAdapter = DataAdapter(dataList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = dataAdapter


    }

}