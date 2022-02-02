package com.example.lessonsFromSamsung.theme54_DelegateAdapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme54_DelegateAdapter.model.Items


class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val header: TextView = itemView.findViewById(R.id.textViewHeader)
    private val description: TextView = itemView.findViewById(R.id.textViewDescription)

    fun bind(item: Items.News) {
        header.text = item.header
        description.text = item.description
    }
}