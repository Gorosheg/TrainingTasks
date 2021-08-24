package com.example.lessonsFromSamsung.theme30_ArrayList

private fun main() {
    val studentsArray = createStudentsArray()
    printStudents(studentsArray) // TODO: Make as extension
    addStudent(studentsArray)
    printStudents(studentsArray)
    excludeStudent(studentsArray)
    printStudents(studentsArray)
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

private fun addStudent(studentsArray: ArrayList<Student>) { // TODO: make and add
    // Добавление элемента в конец списка
    // TODO: extract func make and add on end. remove comment
    studentsArray.add(Student(fullName = "Степанова Анна Викторовна", classNumber = 11))

    // Добавление элемента в нужное место по идексу
    studentsArray.add(3, Student(fullName = "Викторов Илья Ильич", classNumber = 11)) // TODO
}

private fun excludeStudent(studentsArray: ArrayList<Student>) {
    // TODO extract func and provide fullName as parameter
    val studentForRemove = studentsArray.find { it.fullName == "Иванов Петр Андреевич" } // Поиск студента по имени

    // Удаление элемента по конкретному студенту, это должен быть тот же экземпляр
    studentsArray.remove(studentForRemove)

    studentsArray.removeAt(2) // Удаление элемента по индексу
}

private fun printStudents(studentsArray: ArrayList<Student>) {
    for (i in 0 until studentsArray.size) {
        printStudent(studentsArray, i)
    }

    println("")
}

private fun printStudent(studentsArray: ArrayList<Student>, index: Int) {
    val forPrint = studentsArray[index] // Находим элемент по индексу
    println(forPrint.fullName + " " + forPrint.classNumber) // Печатаем нужные поля

}