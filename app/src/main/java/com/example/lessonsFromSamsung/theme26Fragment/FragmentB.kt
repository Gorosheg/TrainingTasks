package com.example.lessonsFromSamsung.theme26Fragment

import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lessonsFromSamsung.R

class FragmentB : Fragment(R.layout.fragment_b_theme_26), FragmentTextChangeListener {

    override fun onTextChanged(text: String) {
        view?.findViewById<TextView>(R.id.text)?.text = text
    }

}