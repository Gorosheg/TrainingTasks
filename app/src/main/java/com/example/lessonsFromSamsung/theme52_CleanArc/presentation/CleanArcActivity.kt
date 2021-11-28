package com.example.lessonsFromSamsung.theme52_CleanArc.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lessonsFromSamsung.R

class CleanArcActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_52_clean)

        val edit: EditText = findViewById(R.id.some_text)
        val btnSave: Button = findViewById(R.id.save_btn)
        val showText: TextView = findViewById(R.id.show_saving_text)
        val btnShow: Button = findViewById(R.id.show_data_btn)

        val a = viewModel.getData()
            .subscribe {
                showText.text = it
            }


        val b = viewModel.error
            .subscribe {
                Toast.makeText(this, "nothing has come", Toast.LENGTH_SHORT).show()
            }

        btnSave.setOnClickListener {
            val text = edit.text.toString()
            viewModel.saveData(text)
        }

        btnShow.setOnClickListener {
            viewModel.getData()
        }

    }
}