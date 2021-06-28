package com.example.lessonsFromSamsung.theme27_2Dgraphics

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R

class GraphicsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Убираем рамку с заголовком активити
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_graphics)
        // setContentView(MyDraw(this))
        // setContentView(CrossingLines(this))
        // setContentView(StripedScreen(this))
        // setContentView(ScreenWithColumns(this))
        // setContentView(Spiral(this))
        setContentView(DrawWithClicks(this))
    }
}