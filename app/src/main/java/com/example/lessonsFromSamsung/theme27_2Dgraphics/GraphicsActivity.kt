package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import kotlinx.android.synthetic.main.activity_theme27_graphics.*

class GraphicsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_27_graphics)

        // Убираем рамку с заголовком активити
        //  requestWindowFeature(Window.FEATURE_NO_TITLE)
        // setContentView(MyDraw(this))
        // setContentView(CrossingLines(this))
        // setContentView(StripedScreen(this))
        // setContentView(ScreenWithColumns(this))
        // setContentView(Spiral(this))
        //  setContentView(DrawWithClicks(this))
        buttonClear.setOnClickListener { clearAll() }
    }

    private fun clearAll() {
        drawingField.clear()
    }
}