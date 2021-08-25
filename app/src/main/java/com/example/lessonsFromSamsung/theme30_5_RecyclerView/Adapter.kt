package com.example.lessonsFromSamsung.theme30_5_RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R

class Adapter(private val values: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    /**
     * Создает новый объект ViewHolder всякий раз,
     * когда создаётся layout строки списка и передается объекту ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_theme_30_5_list_item,
                parent,
                false
            )
        return ViewHolder(itemView)
    }

    /**
     * Принимает объект ViewHolder и устанавливает необходимые данные для соответствующей строки во view-компоненте.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    /**
     * Возвращает общее количество элементов списка.
     * Значения списка передаются с помощью конструктора.
     */
    override fun getItemCount(): Int = values.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
        private var smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)

        fun bind(value: String) {
            largeTextView.text = value
            smallTextView.text = "Кот"
        }

    }

}