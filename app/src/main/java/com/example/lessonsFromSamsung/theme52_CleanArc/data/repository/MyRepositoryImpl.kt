package com.example.lessonsFromSamsung.theme52_CleanArc.data.repository

import com.example.lessonsFromSamsung.theme52_CleanArc.domain.MyRepository
import io.reactivex.Observable

class MyRepositoryImpl() : MyRepository {

    override fun saveData(text: String): Observable<Boolean> {
        SavingText.someText = text
        return Observable.just(text != "")
    }

    override fun getData(): Observable<String> {
        return Observable.just(SavingText.someText)
    }

    object SavingText {
        var someText = ""
    }
}