package com.example.lessonsFromSamsung.theme54_DelegateAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lessonsFromSamsung.theme54_DelegateAdapter.model.Items

internal class CitiesDiffCallback(
    private val oldList: List<Items>,
    private val newList: List<Items>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItems = oldList[oldItemPosition]
        val newItems = newList[newItemPosition]
        return oldItems == newItems
    }

}