package com.example.lessonsFromSamsung.theme16TestingAndDebugging

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import kotlinx.android.synthetic.main.activity_theme_16.*

private const val LOGIN = "asdfg"
private val PASSWORD = "12345"

class Theme16 : AppCompatActivity() {

    var buttonClickCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_16)

        changeBackgroundColor.setOnClickListener { changeBackgroundColor() }
        entranceButton.setOnClickListener { checkDataForLogin() }
    }

    private fun changeBackgroundColor() {
        when (buttonClickCounter) {
            0 -> backGround.setBackgroundColor(Color.RED)
            1 -> backGround.setBackgroundColor(Color.YELLOW)
            2 -> backGround.setBackgroundColor(Color.GREEN)
            3 -> backGround.setBackgroundColor(Color.WHITE)
        }

        buttonClickCounter++

        if (buttonClickCounter == 4) {
            buttonClickCounter = 0
        }
    }

    private fun checkDataForLogin() {
        if (isCorrectCredentials()) {
            toast("Вход выполнен")
        } else {
            toast("Неверный логин или пароль")
        }
    }

    private fun isCorrectCredentials(): Boolean {
        val login = editLogin.text.toString()
        val password = editPassword.text.toString()
        return login == LOGIN && password == PASSWORD
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

}