package com.example.lessonsFromSamsung.theme52_CleanArc.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_52_task)

        val mytext: EditText = findViewById(R.id.textForSaving)
        val button: Button = findViewById(R.id.saveAndContinueBtn)
        button.setOnClickListener {
            val intent = Intent(this, CleanArcActivity::class.java)
            intent.putExtra(MY_TEXT_ARG, mytext.text.toString())
            startActivity(intent)
        }

    }

    companion object {

        const val MY_TEXT_ARG = "MY_TEXT_ARG"

    }

}