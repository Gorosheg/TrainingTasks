package com.example.lessonsFromSamsung.theme45_SQLite

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.example.lessonsFromSamsung.R

class SQLiteActivity : AppCompatActivity() {

    private val database by lazy { MyDatabase(this) }
    var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_45_sqlite)

        fillDatabase()

        val products: List<Product> = getProducts()
        fillViews(products)
        showProduct(products)
    }

    private fun fillDatabase() {
        if (getProducts().isEmpty()) {
            createInitialProducts().forEach {
                database.putProduct(it)
            }
        }
    }

    private fun showProduct(
        products: List<Product>
    ) {
        val next: Button = findViewById(R.id.next)
        val back: Button = findViewById(R.id.previous)
        val size = products.size

        next.setOnClickListener {
            id += 1
            fillViews(products)
            if (id == size - 1) {
                next.isInvisible = true
            }
            if (id != 0) {
                back.isInvisible = false
            }
        }

        back.setOnClickListener {
            id -= 1
            fillViews(products)
            if (id == 0) {
                back.isInvisible = true
            }
            if (id != size - 1) {
                next.isInvisible = false
            }
        }

    }

    private fun fillViews(products: List<Product>) {
        val productName: TextView = findViewById(R.id.name)
        val productBrand: TextView = findViewById(R.id.brand)
        val productId: TextView = findViewById(R.id.id)
        val productPrice: TextView = findViewById(R.id.price)

        productName.text = products[id].name
        productBrand.text = products[id].brand
        productId.text = id.toString()
        productPrice.text = products[id].price.toString()
    }

    private fun createInitialProducts(): List<Product> {
        return listOf(
            Product(brand = "Nestle", name = "Шоколад", price = 97.50),
            Product(brand = "Milka", name = "Шоколад", price = 95.00),
            Product(brand = "Lipton", name = "Чай", price = 113.50),
            Product(brand = "Orbit", name = "Жвачка", price = 35.70),
            Product(brand = "BonAqua", name = "Вода", price = 26.50),
            Product(brand = "Mars", name = "Шоколад", price = 53.80)
        )
    }

    private fun getProducts(): List<Product> {
        return database.getAllProducts()
    }
}