package com.example.lessonsFromSamsung.theme30_5_RecyclerView

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.model.Cat
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.recycler.CatAdapter

class RecyclerViewActivity : AppCompatActivity(), OnCatClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_30_5_recycler_view)

        // LinearLayoutManager показывает список вертикально(горизонтально)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = CatAdapter(
            cats = buildList(),
            onCatClickListener = this, // Передаём activity как OnCatClickListener
            onCatClickListener1 = ::onCatClick1 // Передаём ссылку на метод
        )
    }

    private fun buildList(): List<Cat> {
        val data = mutableListOf<Cat>()

        (0..30).forEach { i ->
            val cat = Cat(id = i, name = "Kitten")
            data.add(cat)
        }

        return data
    }

    override fun onCatClick(cat: Cat) {
        Toast.makeText(this, "Interface " + cat.id.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun onCatClick1(cat: Cat) {
        Toast.makeText(this, "Lambda " + cat.id.toString(), Toast.LENGTH_SHORT).show()
    }

}