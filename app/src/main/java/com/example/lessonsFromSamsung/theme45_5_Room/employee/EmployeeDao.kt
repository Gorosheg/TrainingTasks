package com.example.lessonsFromSamsung.theme45_5_Room.employee

import androidx.room.*


// В @Dao описываются методы для работы с базой данных
@Dao
interface EmployeeDao {

    @Query("SELECT * FROM workers") // Запросы для получения данных
    fun getAll(): List<Employee>

    /*@Query("SELECT * FROM workers")
    fun getAll(): LiveData<List<Employee>> // Возвращает данные в liveData*/

    @Query("SELECT * FROM workers WHERE id =:id")
    fun getById(id: Long): Employee

    @Query("SELECT * FROM workers WHERE salary BETWEEN :minSalary AND :maxSalary")
    fun getAllWithSalaryBetween(minSalary: Int, maxSalary: Int): List<Employee>

    @Insert // Добавление элемента
    fun insert(employee: Employee)

    /*
    @Insert
    fun insertMany(vararg employers: Employee) // Возможность добавлять несколько объектов

    @Insert
    fun insert(employers: List<Employee>)

    @Insert
    fun insert(employers: Iterable<Employee>)

    @Insert
    fun insert(employers: List<Employee>): Array<Long> // Возвращает массив числовых первичных ключей(id), если

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Если в таблице уже есть запись с таким ключом, она будет заменена этой
    fun insert(employee: Employee): Long // Возвращает числовой первичный ключ(id)
    */

    @Update // Обновление таблицы
    fun update(employee: Employee)

    /*
    @Update
    fun update(employee: Employee): Int // Возвращает количество обновленных записей
    */

    @Delete // Удаление элемента
    fun delete(employee: Employee)

    /*
    @Delete
    fun delete(employee: Employee) // Возвращает количество удаленных записей
      */
}