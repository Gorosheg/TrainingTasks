package com.example.lessonsFromSamsung.theme45_SQLite

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.example.lessonsFromSamsung.R

class SQLiteActivity : AppCompatActivity() {

    private val database by lazy { MyDatabase(this) }
    var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_45_sqlite)

        val productName: TextView = findViewById(R.id.name)
        val productBrand: TextView = findViewById(R.id.brand)
        val productId: TextView = findViewById(R.id.id)
        val productPrice: TextView = findViewById(R.id.price)
        val back: Button = findViewById(R.id.previous)
        val next: Button = findViewById(R.id.next)

        initDatabase()
        val products: List<Product> = getProducts()

        showProduct(next, productName, productBrand, productId, productPrice, products)
    }

    private fun showProduct(
        next: Button,
        productName: TextView,
        productBrand: TextView,
        productId: TextView,
        productPrice: TextView,
        products: List<Product>
    ) {
        val size = products.size
        next.setOnClickListener {
            productName.text = products[id].name
            productBrand.text = products[id].brand
            productId.text = products[id].id.toString()
            productPrice.text = products[id].price.toString()
            id += 1
            if (id == size - 1) {
                next.isGone = true
            }
        }

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

    private fun getProducts(): List<Product> {
        return database.getAllProducts()
    }
}