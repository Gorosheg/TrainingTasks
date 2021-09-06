package com.example.lessonsFromSamsung.main.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.main.model.Theme

class MainAdapter(
    private val activities: List<Theme>,
    private val onActivityClickListener: (Theme) -> Unit
) : RecyclerView.Adapter<ActivityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_themes, parent, false)

        return ActivityViewHolder(
            itemView = itemView,
            onActivityClickListener = onActivityClickListener
        )
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(activities[position])
    }

    override fun getItemCount(): Int = activities.size

}