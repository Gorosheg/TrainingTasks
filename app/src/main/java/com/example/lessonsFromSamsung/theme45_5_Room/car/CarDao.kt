package com.example.lessonsFromSamsung.theme45_5_Room.car

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface CarDao {

    @Query("SELECT * FROM car")
    fun getAll(): List<Car>

    @Insert
    fun insert(car: Car)


    @Delete
    fun delete(car: Car)
}