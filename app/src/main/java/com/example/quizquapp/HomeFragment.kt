package com.example.quizquapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        val btnTekonologi: Button = view.findViewById(R.id.btnTekonologi)

        btnTekonologi.setOnClickListener {
            moveToActivity(it)
        }

        return view
    }

    //  function untuk membuka activity
    private fun moveToActivity(view: View) {
        val intent = Intent(context, QuizTeknologiActivity::class.java)
        startActivity(intent)
    }

}