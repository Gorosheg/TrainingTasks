package com.example.lessonsFromSamsung.theme45_5_Room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme45_5_Room.employee.Employee
import com.example.lessonsFromSamsung.theme45_5_Room.employee.EmployeeAddress
import com.example.lessonsFromSamsung.theme45_5_Room.employee.EmployeeDataChanges

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_45_5_room)

        val employee = newEmployee(1)
        EmployeeDataChanges().run {
            addEmployee(employee)
            addEmployee(newEmployee(2))
            changeEmployeesData(employee, 50)
            allEmployees()
            deleteEmployee(employee)
        }

    }

    // Создание нового сотрудника
    private fun newEmployee(id: Long): Employee {
        return Employee(
            id = id,
            firstName = "John",
            lastName = "Smith",
            salary = 10000,
            address = EmployeeAddress("Moscow", "Lenin", 43)

        )
    }


}