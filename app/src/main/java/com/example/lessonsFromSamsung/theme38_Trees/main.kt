package com.example.lessonsFromSamsung.theme38_Trees

fun main(args: Array<String>) {
    val b = intArrayOf(10, 25, 20, 6, 4, 8, 50, 30, 6)
    // Создаем экземпляр класса с ПЕРВЫМ элементом
    val tree = BinaryTree(value = b[0])
    for (element in b) {
        tree.insertNode(tree, element) // Передаем первый элемент и остальные поочереди
    }
    tree.printBinaryTree(tree, 0)
}