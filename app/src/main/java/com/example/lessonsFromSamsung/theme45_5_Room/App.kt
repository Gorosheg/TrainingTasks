package com.example.lessonsFromSamsung.theme45_5_Room

import android.app.Application
import androidx.room.Room


// Класс для создания и хранения БД
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
    }

    companion object {
        lateinit var database: AppDatabase
    }
}