package com.example.lessonsFromSamsung.theme52_CleanArc.domain

import io.reactivex.Observable

interface MyRepository {
    fun saveData(text: String): Observable<Boolean>

    fun getData(): Observable<String>

}