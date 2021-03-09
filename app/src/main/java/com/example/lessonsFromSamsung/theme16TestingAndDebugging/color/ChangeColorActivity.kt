package com.example.lessonsFromSamsung.theme16TestingAndDebugging.color

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import kotlinx.android.synthetic.main.activity_change_color.*

class ChangeColorActivity : AppCompatActivity() {

    private var userColor = MyBackgroundColor.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_color)

        applyUserColor(intent.getStringExtra(KEY_COLOR))

        radioGroup.setOnCheckedChangeListener { _, i ->
            userColor = getMyBackgroundColor(i)
        }

        confirmAndReturnButton.setOnClickListener {
            startMainChangeColorActivity(userColor)
        }
    }

    private fun applyUserColor(userColorName: String?) {
        userColor =
            if (userColorName != null) MyBackgroundColor.valueOf(userColorName)
            else MyBackgroundColor.WHITE

        when (userColor) {
            MyBackgroundColor.RED -> red.isChecked = true
            MyBackgroundColor.GREEN -> green.isChecked = true
            MyBackgroundColor.YELLOW -> yellow.isChecked = true
            MyBackgroundColor.BLUE -> blue.isChecked = true
            MyBackgroundColor.WHITE -> radioGroup.clearCheck()
        }
    }

    private fun getMyBackgroundColor(radioButtonId: Int): MyBackgroundColor {
        return when (radioButtonId) {
            R.id.red -> MyBackgroundColor.RED
            R.id.green -> MyBackgroundColor.GREEN
            R.id.yellow -> MyBackgroundColor.YELLOW
            R.id.blue -> MyBackgroundColor.BLUE
            else -> MyBackgroundColor.WHITE
        }
    }

    private fun startMainChangeColorActivity(color: MyBackgroundColor) {
        val intent = Intent()
        intent.putExtra(KEY_COLOR, color.name)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    companion object {

        const val KEY_COLOR: String = "userColor"

    }

}