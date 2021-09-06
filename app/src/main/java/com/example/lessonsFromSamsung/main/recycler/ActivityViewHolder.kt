package com.example.lessonsFromSamsung.main.recycler

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.main.model.Theme

class ActivityViewHolder(
    itemView: View,
    private val onActivityClickListener: (Theme) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private var listLayout: LinearLayout = itemView.findViewById(R.id.listLayout)
    private var themeTextView: TextView = itemView.findViewById(R.id.themeTextView)

    private var activity: Theme? = null

    init {
        listLayout.setOnClickListener {
            activity?.let(onActivityClickListener::invoke)
        }
    }

    fun bind(activity: Theme){
        this.activity = activity

        themeTextView.text = activity.title
    }
}