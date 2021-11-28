package com.example.lessonsFromSamsung.theme52_CleanArc.domain

import io.reactivex.Observable

class ShowUseCase(private val myRepository: MyRepository) {

    fun showData(): Observable<String> {
        return myRepository.getData()
    }
}