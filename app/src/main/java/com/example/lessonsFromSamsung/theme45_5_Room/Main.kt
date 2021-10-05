package com.example.lessonsFromSamsung.theme45_5_Room

class Main() {
    private val db = App().instance.database //Получение БД
    private val employeeDao = db.employeeDao // Получение EmployeeDao через AppDatabase

    // Создание нового сотрудника
    private val employee = Employee(
        id = 1,
        name = "John Smith",
        salary = 10000
    )

    // Добавление нового сотрудника в БД
    val addEmployee = employeeDao.insert(employee)

    // Получение списка всех сотрудников
    val allEmployees = employeeDao.getAll()

    // Получение сотрудника по id
    var getEmployee = employeeDao.getById(1)

    // Обновление данных по сотруднику
    fun changeEmployeesData() {
        employee.salary = 20000
        employeeDao.insert(employee)
    }

    // Удаление сотрудника
    fun deleteEmployee() {
        employeeDao.delete(employee)
    }

}