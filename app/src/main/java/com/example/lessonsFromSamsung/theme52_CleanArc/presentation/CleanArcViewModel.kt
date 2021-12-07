package com.example.lessonsFromSamsung.theme52_CleanArc.presentation

import androidx.lifecycle.ViewModel
import com.example.lessonsFromSamsung.theme52_CleanArc.domain.CleanArcInteractor
import io.reactivex.Observable

class CleanArcViewModel(private val interactor: CleanArcInteractor, private val number: Int) : ViewModel() {

    val data: Observable<String>
        get() = interactor.data

    val myText: Observable<String>
        get() = interactor.myText

    fun saveData(text: String) {
        interactor.saveData(text)
    }

}