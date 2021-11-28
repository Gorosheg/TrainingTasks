package com.example.lessonsFromSamsung.theme52_CleanArc.domain

import io.reactivex.Observable

class SaveUseCase(private val myRepository: MyRepository) {

    fun saveData(text: String): Observable<Boolean> {
        return myRepository.saveData(text)
    }
}