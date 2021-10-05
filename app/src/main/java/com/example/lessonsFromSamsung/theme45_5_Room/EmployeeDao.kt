package com.example.lessonsFromSamsung.theme45_5_Room

import androidx.room.*


// В @Dao описываются методы для работы с базой данных
@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employee") // Запросы для получения данных
    fun getAll(): List<Employee>

    @Query("SELECT * FROM employee WHERE id =:id")
    fun getById(id: Long): Employee

    @Insert // Добавление элемента
    fun insert(employee: Employee)

    @Update // Обновление таблицы
    fun update(employee: Employee)

    @Delete // Удаление элемента
    fun delete(employee: Employee)
}