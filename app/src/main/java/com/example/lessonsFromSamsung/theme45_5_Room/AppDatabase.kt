package com.example.lessonsFromSamsung.theme45_5_Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lessonsFromSamsung.theme45_5_Room.car.Car
import com.example.lessonsFromSamsung.theme45_5_Room.car.CarDao
import com.example.lessonsFromSamsung.theme45_5_Room.employee.Employee
import com.example.lessonsFromSamsung.theme45_5_Room.employee.EmployeeDao


// Основной класс по работе с БД
@Database(entities = [Employee::class, Car::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val employeeDao: EmployeeDao
    abstract val carDao: CarDao
}