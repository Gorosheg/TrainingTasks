package com.example.lessonsFromSamsung.theme45_SQLite

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R

class AddElementsActivity : AppCompatActivity() {
    private val database by lazy { MyDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_45_add_elements)

        val add: Button = findViewById(R.id.add_button)

        add.setOnClickListener {
            addProduct()
            startAddElementActivity()
        }

    }

    private fun addProduct() {
        val brand: EditText = findViewById(R.id.edit_brand)
        val name: EditText = findViewById(R.id.edit_name)
        val price: EditText = findViewById(R.id.edit_price)

        database.putProduct(
            Product(
                brand.text.toString(),
                name.text.toString(),
                price.text.toString().toDouble()
            )
        )
    }

    private fun startAddElementActivity() {
        val intent = Intent(this, SQLiteActivity::class.java)
        startActivity(intent)
    }
}