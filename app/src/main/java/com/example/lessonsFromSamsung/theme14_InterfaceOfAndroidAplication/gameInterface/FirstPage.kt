package com.example.lessonsFromSamsung.theme14_InterfaceOfAndroidAplication.gameInterface

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import kotlinx.android.synthetic.main.activity_theme_14_first.*

class FirstPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_14_first)

        startGameButton.setOnClickListener {
            val intent = Intent(this, NewGame::class.java)
            startActivity(intent)
        }

        settingsButton.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

        recordsButton.setOnClickListener {
            val intent = Intent(this, Records::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            toast("Выход выполнен")
            finish()
        }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}