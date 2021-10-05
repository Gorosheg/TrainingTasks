package com.example.lessonsFromSamsung.theme45_5_Room

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity - Помечает объект, который будет храниться в БД.
// Имя класса = имени таблицы
@Entity
class Employee(
    @PrimaryKey
    val id: Long,

    val name: String,

    val salary: Int
) {
}