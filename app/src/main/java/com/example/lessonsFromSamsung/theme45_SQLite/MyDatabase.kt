package com.example.lessonsFromSamsung.theme45_SQLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.String

class MyDatabase(context: Context) : SQLiteOpenHelper(context, "MyDatabase", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            """CREATE TABLE Project(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, brand TEXT, price REAL)""",
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

    fun getAllProjects(): List<Product> {
        val cursor = readableDatabase.rawQuery(
            """SELECT * FROM Project""", null
        )

        return readProductsFromCursor(cursor)
    }

    private fun readProductsFromCursor(cursor: Cursor): List<Product> {
        val list = mutableListOf<Product>()

        if (cursor.moveToFirst()) { // метод передвигает курсор на первый элемент, возвращает false, если не удалось или нет элемента
            do {
                val product = readProduct(cursor)
                list.add(product)
            } while (cursor.moveToNext())
        }

        return list
    }

    fun getProduct(id: Long): Product {
        val cursor = readableDatabase.rawQuery(
            """SELECT * FROM Product WHERE _id = ?""", arrayOf(String.valueOf(id))
        )
        return readProductsFromCursor(cursor)[0]
    }

    private fun readProduct(cursor: Cursor): Product {
        return Product(
            cursor.getLong(cursor.getColumnIndex("_id")),
            cursor.getString(cursor.getColumnIndex("brand")),
            cursor.getString(cursor.getColumnIndex("name")),
            cursor.getDouble(cursor.getColumnIndex("price"))
        )
    }

}