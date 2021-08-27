package com.example.lessonsFromSamsung.theme30_5_RecyclerView.recycler

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.OnCatClickListener
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.model.Cat

class CatViewHolder(
    itemView: View,
    private val onCatClickListener: OnCatClickListener,
    private val onCatClickListener1: (Cat) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private var rootLayout: LinearLayout = itemView.findViewById(R.id.rootLayout)
    private var largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
    private var smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)

    private var cat: Cat? = null

    init {
        rootLayout.setOnClickListener {
            // Метод onCatClick будет вызван у класса onCatClickListener, когда cat != null
            cat?.let(onCatClickListener::onCatClick)

            // Вызываем наш метод
            cat?.let(onCatClickListener1::invoke)
        }
    }

    fun bind(cat: Cat) {
        this.cat = cat

        largeTextView.text = cat.id.toString()
        smallTextView.text = cat.name
    }

}