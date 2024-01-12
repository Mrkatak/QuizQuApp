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
            DataItem(2, R.drawable.ic_iot, "Pengembangan Android", getString(R.string.pengembanganAndroid)),
            DataItem(3, R.drawable.ic_iot, "Juara dunia VS Komputer", getString(R.string.deepblue)),
            DataItem(4, R.drawable.ic_iot, "Taiwan Semiconductor Manufacturing Company (TSMC)", getString(R.string.tsmc)),
            DataItem(5, R.drawable.ic_iot, "Sistem Operasi Linux", getString(R.string.linux)),

        )

        dataAdapter = DataAdapter(dataList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = dataAdapter


    }

}