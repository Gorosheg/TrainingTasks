package com.example.lessonsFromSamsung.theme27_2Dgraphics.ticTacToe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TicTacToe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TicTacToeDraw(this))
    }
}