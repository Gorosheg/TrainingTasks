package com.example.lessonsFromSamsung.theme45_SQLite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R

class SQLiteActivity : AppCompatActivity() {
    val database = MyDatabase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_45_sqlite)

        initDatabase()
        val product = getProduct()
    }

    private fun initDatabase() {
        database.putProduct(Product(0, "Nestle", "Шоколад", 97.50))
        database.putProduct(Product(1, "Milka", "Шоколад", 95.00))
        database.putProduct(Product(2, "Lipton", "Чай", 113.50))
        database.putProduct(Product(3, "Orbit", "Жвачка", 35.70))
        database.putProduct(Product(4, "BonAqua", "Вода", 26.50))
        database.putProduct(Product(5, "Mars", "Шоколад", 53.80))
    }

    private fun getProduct(): Product {
        return database.getProduct(2)
    }
}