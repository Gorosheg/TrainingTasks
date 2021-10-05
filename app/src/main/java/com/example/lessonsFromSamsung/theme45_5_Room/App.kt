package com.example.lessonsFromSamsung.theme45_5_Room

import android.app.Application
import androidx.room.Room


// Класс для создания и хранения БД
class App : Application() {
    var database: AppDatabase? = null
    var instance: App? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
    }
}