package com.example.lessonsFromSamsung.theme26_Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lessonsFromSamsung.R

class FragmentA : Fragment() {

    var fragmentTextChangeListener: FragmentTextChangeListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a_theme_26, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button1: Button = view.findViewById(R.id.button1)
        makeToastOnButton(button1, view)

        val button2: Button = view.findViewById(R.id.button2)
        setTextByButton(button2)
    }

    private fun makeToastOnButton(button1: Button, view: View) {
        button1.setOnClickListener {
            Toast.makeText(view.context, "Вы нажали на кнопку", Toast.LENGTH_SHORT).show()
            fragmentTextChangeListener?.onTextChanged(text = "Синий")
        }
    }

    private fun setTextByButton (button2: Button){
        button2.setOnClickListener{
            fragmentTextChangeListener?.onTextChanged(text = "Красный")
        }
    }

}