package com.example.lessonsFromSamsung.theme45_5_Room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_45_5_room)

        val employee = newEmployee(1)
        DatabaseDataChanges().addEmployee(employee)
        DatabaseDataChanges().addEmployee(newEmployee(2))
        DatabaseDataChanges().changeEmployeesData(employee, 50)
        DatabaseDataChanges().allEmployees()
        DatabaseDataChanges().deleteEmployee(employee)
    }

    // Создание нового сотрудника
    private fun newEmployee(id: Long): Employee {
        return Employee(
            id = id,
            name = "John Smith",
            salary = 10000
        )
    }


}