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

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun putProduct(product: Product) {
        val database: SQLiteDatabase = writableDatabase

        val contentValues: ContentValues = ContentValues()
        contentValues.put("brand", product.brand)
        contentValues.put("name", product.name)
        contentValues.put("price", product.price)

        database.insert("Product", null, contentValues)
        database.close()
    }

    private fun getAllProject(): List<Product> {
        val cursor = readableDatabase.rawQuery(
            """SELECT * FROM Project""", null
        )

        return readProductsFromCursor(cursor)
    }

    private fun readProductsFromCursor(cursor: Cursor): List<Product> {
        val list: ArrayList<Product> = ArrayList()

        if (cursor.moveToFirst()) {
            do {
                val product = readProduct(cursor)
                list.add(product)

            } while (cursor.moveToNext())
        }

        return list
    }

    private fun getProduct(id: Long): Product {
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