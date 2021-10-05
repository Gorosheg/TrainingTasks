package com.example.lessonsFromSamsung.theme45_5_Room.car

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.example.lessonsFromSamsung.theme45_5_Room.employee.Employee

//@Entity(primaryKeys = ["id", "model"]) // Составной ключ

@Entity(
    foreignKeys = [ForeignKey(
        entity = Employee::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("employee_id"),
        onDelete = CASCADE // При удалении родительского ключа, будут удалены, связанные с ним дочерние ключи.
    )]
)
class Car(
    @PrimaryKey
    val id: Long,
    val model: String,
    val year: Int,
    @ColumnInfo(name = "employee_id")
    val employeeId: Long
)