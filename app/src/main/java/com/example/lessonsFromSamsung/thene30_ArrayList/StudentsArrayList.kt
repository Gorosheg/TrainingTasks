package com.example.lessonsFromSamsung.thene30_ArrayList

private fun main() {
    val studentsArray = createStudentsArray()
    printStudents(studentsArray)
    addStudent(studentsArray)
    printStudents(studentsArray)
    excludeStudent(studentsArray)
    printStudents(studentsArray)
}

private fun createStudentsArray(): ArrayList<Student> {
    return arrayListOf(
        Student(
            "Иванов Петр Андреевич",
            3
        ),
        Student(
            "Петров Андрей Иванович",
            6
        ),
        Student(
            "Андреев Иван Петрович",
            10
        ),
        Student(
            "Сидорова Елена Анатольевна",
            4
        ),
        Student(
            "Антонова Софья Степановна",
            6
        )
    )
}

private fun addStudent(studentsArray: ArrayList<Student>) {
    // Добавление элемента в конец списка
    studentsArray.add(Student("Степанова Анна Викторовна", 11))
    // Добавление элемента в нужное место по идексу
    studentsArray.add(3, Student("Викторов Илья Ильич", 11))
}

private fun excludeStudent(studentsArray: ArrayList<Student>) {
    // TODO: Не работает по имени
    studentsArray.remove(Student("Петров Андрей Иванович", 6)) // Удаление элемента по имени
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