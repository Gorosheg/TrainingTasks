package com.example.lessonsFromSamsung.theme45_5_Room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme45_5_Room.employee.Employee
import com.example.lessonsFromSamsung.theme45_5_Room.employee.EmployeeDataChanges

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_45_5_room)

        val employee = newEmployee(1)
        EmployeeDataChanges().addEmployee(employee)
        EmployeeDataChanges().addEmployee(newEmployee(2))
        EmployeeDataChanges().changeEmployeesData(employee, 50)
        EmployeeDataChanges().allEmployees()
        EmployeeDataChanges().deleteEmployee(employee)
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