package com.example.lessonsFromSamsung.theme45_SQLite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R

class SQLiteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_45_sqlite)

        val database = MyDatabase(this)
    }
}