package com.example.lessonsFromSamsung.theme30_ArrayList

private fun main() {
    val studentsArray = createStudentsArray()
    studentsArray.run {
        printStudents()
        addStudent()
        printStudents()
        excludeStudent()
        printStudents()
    }
}

private fun createStudentsArray(): ArrayList<Student> = arrayListOf(
    Student(
        fullName = "Иванов Петр Андреевич",
        classNumber = 3
    ),
    Student(
        fullName = "Петров Андрей Иванович",
        classNumber = 6
    ),
    Student(
        fullName = "Андреев Иван Петрович",
        classNumber = 10
    ),
    Student(
        fullName = "Сидорова Елена Анатольевна",
        classNumber = 4
    ),
    Student(
        fullName = "Антонова Софья Степановна",
        classNumber = 6
    )
)

private fun ArrayList<Student>.addStudent() {
    // Добавление элемента в конец списка
    makeAndAddToEnd()
    // Добавление элемента в нужное место по идексу
    makeAndAddByIndex()
}

private fun ArrayList<Student>.makeAndAddToEnd() {
    add(Student(fullName = "Степанова Анна Викторовна", classNumber = 11))
}

private fun ArrayList<Student>.makeAndAddByIndex() {
    add(3, Student(fullName = "Викторов Илья Ильич", classNumber = 11))
}

private fun ArrayList<Student>.excludeStudent() {
    // Поиск студента по имени
    val studentForRemove = findByName()

    // Удаление элемента по конкретному студенту, это должен быть тот же экземпляр
    remove(studentForRemove)

    // Удаление элемента по индексу
    removeAt(2)
}

private fun ArrayList<Student>.findByName(): Student? {
    return find { it.fullName == "Иванов Петр Андреевич" }
}

private fun ArrayList<Student>.printStudents() {
    for (i in 0 until size) {
        printStudent(this, i)
    }

    println("")
}

private fun printStudent(studentsArray: ArrayList<Student>, index: Int) {
    val forPrint = studentsArray[index] // Находим элемент по индексу
    println(forPrint.fullName + " " + forPrint.classNumber) // Печатаем нужные поля
}