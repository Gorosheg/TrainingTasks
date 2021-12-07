package com.example.lessonsFromSamsung.theme52_CleanArc.presentation

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.lessonsFromSamsung.R
import io.reactivex.disposables.Disposable
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CleanArcActivity : AppCompatActivity() {
    private val text = "MyText"
    private val number = 6
    private val viewModel: CleanArcViewModel by viewModel { parametersOf(text, number) }
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