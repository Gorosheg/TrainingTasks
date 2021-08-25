package com.example.lessonsFromSamsung.theme30_5_RecyclerView.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.model.Cat

class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
    private var smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)

    fun bind(cat: Cat) {
        largeTextView.text = cat.id.toString()
        smallTextView.text = cat.name
    }

}