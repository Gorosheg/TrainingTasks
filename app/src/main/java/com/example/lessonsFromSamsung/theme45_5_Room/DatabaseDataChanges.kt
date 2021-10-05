package com.example.lessonsFromSamsung.theme45_5_Room

class DatabaseDataChanges {
    private val db = App.database //Получение БД
    private val employeeDao = db.employeeDao // Получение EmployeeDao через AppDatabase

    // Добавление нового сотрудника в БД
    fun addEmployee(employee: Employee) {
        employeeDao.insert(employee)
    }

    // Получение списка всех сотрудников
    fun allEmployees(): List<Employee> {
        return employeeDao.getAll()
    }

    // Получение сотрудника по id
    fun getEmployee(id: Long): Employee {
        return employeeDao.getById(id)
    }

    // Обновление данных по сотруднику
    fun changeEmployeesData(employee: Employee, newSalary:Int) {
        employee.salary = newSalary
        employeeDao.update(employee)
    }

    // Удаление сотрудника
    fun deleteEmployee(employee: Employee) {
        employeeDao.delete(employee)
    }

}