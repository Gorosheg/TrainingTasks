package com.example.lessonsFromSamsung.theme38_Trees

class BinaryTree(
    var value: Int = 0,
    var lchild: BinaryTree? = null,
    var rchild: BinaryTree? = null
) {

    fun insertNode(node: BinaryTree?, targetValue: Int): BinaryTree? {
        var node = node
        if (node == null) {
            node = BinaryTree(targetValue)
            return node
        }

        if (node.value > targetValue) {
            if (node.lchild == null) {
                node.lchild = BinaryTree(targetValue)
                return node.lchild
            } else {
                return insertNode(node.lchild, targetValue)
            }
        } else if (node.value < targetValue) {
            if (node.rchild == null) {
                node.rchild = BinaryTree(targetValue)
                return node.rchild
            } else {
                return insertNode(node.rchild, targetValue)
            }
        }
        return null
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