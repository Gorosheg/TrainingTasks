package com.example.lessonsFromSamsung.theme52_CleanArc.domain

import io.reactivex.Observable

interface CleanArcInteractor {

    val data: Observable<String>

    val myText: Observable<String>

    fun saveData(text: String)

}