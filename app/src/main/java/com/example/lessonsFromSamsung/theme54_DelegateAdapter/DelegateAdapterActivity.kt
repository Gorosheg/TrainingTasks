package com.example.lessonsFromSamsung.theme54_DelegateAdapter

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme54_DelegateAdapter.model.Items
import java.util.*


class DelegateAdapterActivity : AppCompatActivity() {

    private val random = Random()

    private val data: MutableList<Items> = mutableListOf()

    private val adapter: DelegateAdapter by lazy {
        DelegateAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_54_delegate_adapter)

        val recyclerView: RecyclerView = findViewById(R.id.delegateRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.items = buildList()

        val btnAdd: Button = findViewById(R.id.add)
        val btnDelete: Button = findViewById(R.id.delete)
        val btnMix: Button = findViewById(R.id.mix)

        btnAdd.setOnClickListener {
            addElement(data.size)
            changeRecycler()
        }

        btnDelete.setOnClickListener {
            if (data.isNotEmpty()) {
                val position = randomPosition()
                removeCity(position)
                changeRecycler()
            }
        }

        btnMix.setOnClickListener {
            if (data.isNotEmpty()) {
                mixList()
                changeRecycler()
            }
        }

    }

    private fun buildList(): List<Items> {
        (0..10).forEach { i ->
            addElement(i)
        }
        return data
    }

    private fun addElement(position: Int) {
        val type = random.nextInt(9)

        if (type in 3..9) {
            val item = Items.News(position, "Header $position", "Description $position")
            data.add(item)
        } else {
            val item = Items.Adverb(position)
            data.add(item)
        }
    }

    private fun removeCity(position: Int) {
        data.removeAt(position)
    }

    private fun mixList() {
        val countOfChanges = random.nextInt(5)

        for (i in 0..countOfChanges) {
            val firstIndex = randomPosition()
            val secondIndex = randomPosition()
            data[firstIndex] = data[secondIndex].also { data[secondIndex] = data[firstIndex] }
        }
    }

    private fun randomPosition(): Int {
        return if (data.size <= 1) 0
        else random.nextInt(data.size - 1)
    }

    private fun changeRecycler() {
        val newList: MutableList<Items> = mutableListOf()

        for (i in 0 until data.size) {
            newList.add(data[i])
        }

        adapter.items = newList
    }

}