package com.example.lessonsFromSamsung.theme22InputOutputExceptions

import com.example.lessonsFromSamsung.utils.scanner
import java.io.File
import java.io.FileNotFoundException
import java.io.FileWriter
import java.io.PrintWriter
import java.util.*

private const val fileName = "d:/ca.txt"

private fun main() {
    File(fileName).run {
        write(scanner.nextLine())
        print()
    }
}

private fun File.write(text: String) {
    try {
        val writer = PrintWriter(FileWriter(this))
        writer.printf(text)
        writer.close()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }
}

private fun File.print() {
    try {
        val scanner = Scanner(this)

        while (scanner.hasNext()) {
            print(scanner.next() + " ")
        }

        scanner.close()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }
}