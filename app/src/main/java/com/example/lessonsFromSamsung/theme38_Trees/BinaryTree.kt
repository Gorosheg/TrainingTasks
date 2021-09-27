package com.example.lessonsFromSamsung.theme38_Trees

class BinaryTree(
    private var value: Int = 0,
    var lchild: BinaryTree? = null,
    private var rchild: BinaryTree? = null
) {

    fun insertNode(oldNode: BinaryTree?, targetValue: Int): BinaryTree? {
        var node = oldNode

        if (node == null) {
            node = BinaryTree(targetValue)
            return node
        }

        return when {
            node.value > targetValue -> {
                if (node.lchild == null) {
                    node.lchild = BinaryTree(targetValue)
                    node.lchild
                } else {
                    insertNode(node.lchild, targetValue)
                }
            }

            node.value < targetValue -> {
                if (node.rchild == null) {
                    node.rchild = BinaryTree(targetValue)
                    node.rchild
                } else {
                    insertNode(node.rchild, targetValue)
                }
            }

            else -> null
        }
    }

    fun printBinaryTree(node: BinaryTree?, level: Int) {
        if (node != null) {
            printBinaryTree(node.lchild, level + 1)
            for (i in 0..level) {
                print("   ")
            }
            println(node.value)
            printBinaryTree(node.rchild, level + 1)
        }
    }

}