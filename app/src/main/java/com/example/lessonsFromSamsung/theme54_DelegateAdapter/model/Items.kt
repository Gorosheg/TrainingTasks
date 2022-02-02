package com.example.lessonsFromSamsung.theme54_DelegateAdapter.model

sealed class Items(var id:Int) {
    class News( id: Int, val header: String, val description: String) : Items(id)

    class Adverb(id: Int) : Items(id)
}