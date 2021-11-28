package com.example.lessonsFromSamsung.theme52_CleanArc.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.lessonsFromSamsung.R
import io.reactivex.disposables.Disposable

class CleanArcActivity : AppCompatActivity() {

    private val viewModel: CleanArcViewModel by lazy { ViewModelProvider(this).get(CleanArcViewModel::class.java) }
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_52_clean)

        val edit: EditText = findViewById(R.id.some_text)
        val showText: TextView = findViewById(R.id.show_saving_text)

        disposable = viewModel.data
            .subscribe {
                showText.text = it
            }

        edit.addTextChangedListener {
            val text = it.toString()
            viewModel.saveData(text)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }

}