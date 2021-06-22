package com.example.lessonsFromSamsung.theme26Fragment

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.lessonsFromSamsung.R

class FragmentC : Fragment(R.layout.fragment_c_theme_26) {

    var fragmentTextColorChangeListener: FragmentTextColorChangeListener? = null
    var a = false
    var b = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val checkBox1: CheckBox = view.findViewById(R.id.CheckBox1)
        val checkBox2: CheckBox = view.findViewById(R.id.CheckBox2)

        firstCheckBoxListener(checkBox1)
        secondCheckBoxListener(checkBox2)
        changeColor(choiceOfColor())
    }

    private fun firstCheckBoxListener(checkBox1: CheckBox) {
        checkBox1.setOnCheckedChangeListener { button, isChecked ->
            a = isChecked
            changeColor(choiceOfColor())
        }
    }

    private fun secondCheckBoxListener(checkBox2: CheckBox) {
        checkBox2.setOnCheckedChangeListener { button, isChecked ->
            b = isChecked
            changeColor(choiceOfColor())
        }
    }

    private fun choiceOfColor(): Int {
        return when {
            !a && !b -> R.color.black
            a && !b -> R.color.blue
            !a && b -> R.color.red
            a && b -> R.color.green
            else -> R.color.white
        }
    }

    private fun changeColor(color: Int) {
        fragmentTextColorChangeListener?.onTextColorChanged(colorRes = color)
    }

}