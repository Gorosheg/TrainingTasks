package com.example.lessonsFromSamsung.theme16TestingAndDebugging.color

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.lessonsFromSamsung.R
import kotlinx.android.synthetic.main.activity_theme_16_main_change_color.*

class MainChangeColorActivity : AppCompatActivity() {

    private var userColor = MyBackgroundColor.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_16_main_change_color)

        goChangeColorPageButton.setOnClickListener { navigateToChangeColorActivity() }
    }

    /**
     * Эта штука вызовется (с нужными параметрами) когда мы вернёмся из предыдущей активити
     * [requestCode] - наш ключ который мы передали ранее (при переходе в следующую активити)
     * [resultCode] - ключ который говорит, что всё ок, сравниваем с [Activity.RESULT_OK]
     * [data] - там наши данные в [Intent]'е
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == KEY_COLOR_CHECK && resultCode == Activity.RESULT_OK) {
            val userColorName = data?.getStringExtra(ChangeColorActivity.KEY_COLOR)
            setBackgroundColor(userColorName)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    /**
     * если вернулось значение не Null,
     * то с помощью class MyBackgroundColor конвертируем то, что пришло, в цвет
     * (а пришло оно в string)
     */
    private fun setBackgroundColor(userColorName: String?) {
        userColor =
            if (userColorName != null) MyBackgroundColor.valueOf(userColorName)
            else MyBackgroundColor.WHITE

        background.setBackgroundColor(ContextCompat.getColor(this, userColor.colorRes))
    }

    private fun navigateToChangeColorActivity() {
        val intent = Intent(this, ChangeColorActivity::class.java)
        intent.putExtra(ChangeColorActivity.KEY_COLOR, userColor.name)
        startActivityForResult(intent, KEY_COLOR_CHECK)
    }

    companion object {

        const val KEY_COLOR_CHECK: Int = 456

    }

}