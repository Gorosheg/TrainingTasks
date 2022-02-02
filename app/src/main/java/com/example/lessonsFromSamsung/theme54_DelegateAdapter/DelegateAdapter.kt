package com.example.lessonsFromSamsung.theme54_DelegateAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme54_DelegateAdapter.model.Items

class DelegateAdapter(firstList: List<Items>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Items> = firstList
        set(value) {
            val diffResult = DiffUtil.calculateDiff(CitiesDiffCallback(items, value))
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_NEWS) {
            val itemView: View = parent.inflate(R.layout.activity_theme_54_news)
            NewsViewHolder(itemView)
        } else {
            val itemView: View = parent.inflate(R.layout.activity_theme_54_adverb)
            AdverbViewHolder(itemView)
        }
    }

    private fun ViewGroup.inflate(layout: Int): View {
        return LayoutInflater.from(context)
            .inflate(layout, this, false)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_NEWS) {
            val item = items[position] as Items.News
            (holder as NewsViewHolder).bind(item)
        } else {
            val item = items[position] as Items.Adverb
            (holder as AdverbViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is Items.News) {
            TYPE_NEWS
        } else {
            TYPE_ADVERB
        }
    }

    companion object {
        private const val TYPE_NEWS = 1
        private const val TYPE_ADVERB = 2
    }
}