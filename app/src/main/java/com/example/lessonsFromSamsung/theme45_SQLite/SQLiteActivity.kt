package com.example.lessonsFromSamsung.theme45_SQLite

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R

class SQLiteActivity : AppCompatActivity() {

    private val database by lazy { MyDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_45_sqlite)

        val productName: TextView = findViewById(R.id.name)
        val productBrand: TextView = findViewById(R.id.brand)
        val productId: TextView = findViewById(R.id.id)
        val productPrice: TextView = findViewById(R.id.price)

        initDatabase()
        val product = getProduct()

        productName.text = product.first().name
        productBrand.text = product.first().brand
        productId.text = product.first().id.toString()
        productPrice.text = product.first().price.toString()
    }

    /**
     * Добавляем продукты в базу
     **/
    private fun initDatabase() {
        database.putProduct(Product(0, "Nestle", "Шоколад", 97.50))
        database.putProduct(Product(1, "Milka", "Шоколад", 95.00))
        database.putProduct(Product(2, "Lipton", "Чай", 113.50))
        database.putProduct(Product(3, "Orbit", "Жвачка", 35.70))
        database.putProduct(Product(4, "BonAqua", "Вода", 26.50))
        database.putProduct(Product(5, "Mars", "Шоколад", 53.80))
    }

    private fun getProduct(): List<Product> {
        return database.getAllProjects()
    }
}