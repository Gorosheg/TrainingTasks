package com.example.lessonsFromSamsung.theme52_CleanArc.data

import io.reactivex.Observable

interface CleanArcRepository {

    val data: Observable<String>

    fun saveData(text: String)

}