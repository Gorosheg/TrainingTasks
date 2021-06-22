package com.example.lessonsFromSamsung.theme26Fragment

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.lessonsFromSamsung.R

class FragmentC : Fragment(R.layout.fragment_c_theme_26) {

    var fragmentTextColorChangeListener: FragmentTextColorChangeListener? = null
    var a = 0 // TODO boolean
    var b = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val checkBox1: CheckBox = view.findViewById(R.id.CheckBox1)
        val checkBox2: CheckBox = view.findViewById(R.id.CheckBox2)

        firstCheckBoxListener(checkBox1)
        secondCheckBoxListener(checkBox2)
        val color = choiceOfColor() // todo в функцию
        changeColor(color)
    }

    private fun firstCheckBoxListener(checkBox1: CheckBox) {
        checkBox1.setOnCheckedChangeListener { button, isChecked ->
            a = if (isChecked) 1 else 0
            val color = choiceOfColor()
            changeColor(color)
        }
    }

    private fun secondCheckBoxListener(checkBox2: CheckBox) {
        checkBox2.setOnCheckedChangeListener { button, isChecked ->
            b = if (isChecked) 1 else 0
            val color = choiceOfColor()
            changeColor(color)
        }
    }

    private fun choiceOfColor(): Int {
        return when {
            a == 0 && b == 0 -> R.color.black
            a == 1 && b == 0 -> R.color.blue
            a == 0 && b == 1 -> R.color.red
            a == 1 && b == 1 -> R.color.green
            else -> R.color.white
        }
    }

    private fun changeColor(color: Int) {
        fragmentTextColorChangeListener?.onTextColorChanged(colorRes = color)
    }

}