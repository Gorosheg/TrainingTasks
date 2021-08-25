package com.example.lessonsFromSamsung.theme30_5_RecyclerView.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.model.Cat

class CatAdapter(private val cats: List<Cat>) : RecyclerView.Adapter<CatViewHolder>() {

    /**
     * Создает новый объект ViewHolder всякий раз,
     * когда создаётся layout строки списка и передается объекту ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_theme_30_5_list_item, parent, false)

        return CatViewHolder(itemView)
    }

    /**
     * Принимает объект ViewHolder и устанавливает необходимые данные для соответствующей строки во view-компоненте.
     */
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(cats[position])
    }

    /**
     * Возвращает общее количество элементов списка.
     * Значения списка передаются с помощью конструктора.
     */
    override fun getItemCount(): Int = cats.size

}