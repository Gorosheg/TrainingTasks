package com.example.lessonsFromSamsung.theme45_5_Room

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.TEXT
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

//@Entity - Помечает объект, который будет храниться в БД.
// Имя класса = имени таблицы
@Entity(
    tableName = "workers", // tableName - меняет имя таблицы
    indices = [ // Индексы проводят проверку на уникальность полей
        Index("salary"),
        Index(value = ["first_name", "last_name"])
    ]
)
class Employee(
    @PrimaryKey(autoGenerate = true) // автоматическое выставление параметра
    val id: Long,

    @ColumnInfo(name = "first_name") // меняет имя поля таблицы
    val firstName: String,

    @ColumnInfo(name = "last_name")
    val lastName: String,

    @ColumnInfo(typeAffinity = TEXT,//меняет тип поля
    index = true) // Задает индекс для поля
    var salary: Int
) {
}