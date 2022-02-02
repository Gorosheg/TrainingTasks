package com.example.lessonsFromSamsung.theme54_DelegateAdapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme54_DelegateAdapter.model.Items
import java.util.*


class DelegateAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_54_delegate_adapter)

        val recyclerView: RecyclerView = findViewById(R.id.delegateRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = DelegateAdapter(buildList())
    }

    private fun buildList(): List<Items> {
        val data = mutableListOf<Items>()
        val random = Random()
        (0..10).forEach { i ->
            val type = random.nextBoolean()
            if (type) {
                val item = Items.News(i, "Header $i", "Description $i")
                data.add(item)
            } else {
                val item = Items.Adverb(i)
                data.add(item)
            }
        }

        return data
    }

}