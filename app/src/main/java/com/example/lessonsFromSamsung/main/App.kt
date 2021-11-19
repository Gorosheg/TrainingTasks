package com.example.lessonsFromSamsung.main

import android.app.Application
import androidx.room.Room
import com.example.lessonsFromSamsung.theme25_services.serviceWithRxjava.MyExampleData
import com.example.lessonsFromSamsung.theme45_5_Room.AppDatabase


// Класс для создания и хранения БД
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries() // Тормозит приложение, вместо этого можно использовать Livedata или RxJava
            .build()

    }

    companion object {
        lateinit var database: AppDatabase
        val myExampleData = MyExampleData()
    }
}