package com.example.lessonsFromSamsung.theme45_SQLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.String

class MyDatabase(context: Context) : SQLiteOpenHelper(context, "MyDatabase", null, 1) {

    /**
     * Создаем базу данных с названием "Product".
     *
     * AUTOINCREMENT - автоматически присваивает id всем элементам таблицы
     * PRIMARY KEY - идентификационный номер элемента по которому можно будет искать элемент
     */
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            """CREATE TABLE Product(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, brand TEXT, price REAL)""",
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) = Unit

    fun putProduct(product: Product) {
        val contentValues = ContentValues().apply {
            put("brand", product.brand)
            put("name", product.name)
            put("price", product.price)
        }

        writableDatabase.run {
            insert("Product", null, contentValues)
            close()
        }
    }

    fun getAllProducts(): List<Product> {
        val cursor = readableDatabase.rawQuery(
            """SELECT * FROM Product""", null
        )

        return readProductsFromCursor(cursor)
    }

    fun getProduct(id: Long): Product {
        val cursor = readableDatabase.rawQuery(
            """SELECT * FROM Product WHERE _id = ?""", arrayOf(String.valueOf(id))
        )
        return readProductsFromCursor(cursor)[id.toInt()]
    }

    private fun readProductsFromCursor(cursor: Cursor): List<Product> {
        val list = mutableListOf<Product>()

        if (cursor.moveToFirst()) { // метод передвигает курсор на первый элемент, возвращает false, если не удалось или нет элемента
            // Считывает жлементы из таблици и добавляет их в List
            do {
                val product = readProduct(cursor)
                list.add(product)
            } while (cursor.moveToNext())
        }

        return list
    }

    /**
     * Берет элемент из таблицы
     */
    private fun readProduct(cursor: Cursor): Product {
        return Product(
            cursor.getString(cursor.getColumnIndex("brand")),
            cursor.getString(cursor.getColumnIndex("name")),
            cursor.getDouble(cursor.getColumnIndex("price"))
        )
    }

}