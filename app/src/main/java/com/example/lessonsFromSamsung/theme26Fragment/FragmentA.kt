package com.example.lessonsFromSamsung.theme26Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lessonsFromSamsung.R

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a_theme_26, container, false)

        val button1: Button = view.findViewById(R.id.button1)

        button1.setOnClickListener {
            Toast.makeText(view.context, "Вы нажали на кнопку", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}