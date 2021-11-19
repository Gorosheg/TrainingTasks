package com.example.lessonsFromSamsung.theme45_5_Room.employee

import com.example.lessonsFromSamsung.main.App

class EmployeeDataChanges {
    private val db = App.database //Получение БД
    private val employeeDao = db.employeeDao // Получение EmployeeDao через AppDatabase

    // Добавление нового сотрудника в БД
    fun addEmployee(employee: Employee) {
        employeeDao.insert(employee)
    }

    /* // Получение списка всех сотрудников
     fun allEmployees(): LiveData<List<Employee>> {
        val employeesLiveData = employeeDao.getAll()
        employeesLiveData.observe(this, object : Observer<List<Employee?>?>() {
             fun onChanged(@Nullable employees: List<Employee?>) {
                log("onChanged $employees")
             }
        })
        return employeesLiveData
    }*/

    // Получение списка всех сотрудников
    fun allEmployees(): List<Employee> {
        return employeeDao.getAll()
    }

    // Получение сотрудника по id
    fun getEmployee(id: Long): Employee {
        return employeeDao.getById(id)
    }

    // Обновление данных по сотруднику
    fun changeEmployeesData(employee: Employee, newSalary: Int) {
        employee.salary = newSalary
        employeeDao.update(employee)
    }

    // Удаление сотрудника
    fun deleteEmployee(employee: Employee) {
        employeeDao.delete(employee)
    }

}