package com.example.lessonsFromSamsung.theme52_CleanArc.domain

import com.example.lessonsFromSamsung.theme52_CleanArc.data.CleanArcRepository
import io.reactivex.Observable

class CleanArcInteractorImpl(private val repository: CleanArcRepository) : CleanArcInteractor {

    override val data: Observable<String>
        get() = repository.data
            .filter { it.length > 3 }
            .map { "$it field mapped" }


    override val myText: Observable<String>
        get() = repository.myText

    override fun saveData(text: String) {
        repository.saveData(text)
    }

}