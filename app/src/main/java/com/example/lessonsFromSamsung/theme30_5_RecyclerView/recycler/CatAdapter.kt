package com.example.lessonsFromSamsung.theme30_5_RecyclerView.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.OnCatClickListener
import com.example.lessonsFromSamsung.theme30_5_RecyclerView.model.Cat

class CatAdapter(
    private val cats: List<Cat>,
    private val onCatClickListener: OnCatClickListener,
    private val onCatClickListener1: (Cat) -> Unit // Lambda, callback - это как функция
) : RecyclerView.Adapter<CatViewHolder>() {

    /**
     * Создает новый объект ViewHolder для каждого элемента в списке cats
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_theme_30_5_list_item, parent, false)

        return CatViewHolder(
            itemView = itemView,
            onCatClickListener = onCatClickListener,
            onCatClickListener1 = onCatClickListener1
        )
    }

    /**
     * Вызывается для каждого view holder всякий раз, когда данные изменились и нужно их отобразить/обновить на экране
     * @param position - это наш index в списке cats, по нему мы достаём конкретного cat
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