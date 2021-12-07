package com.example.lessonsFromSamsung.theme52_CleanArc.presentation

import androidx.lifecycle.ViewModel
import com.example.lessonsFromSamsung.theme52_CleanArc.domain.CleanArcInteractor
import io.reactivex.Observable

class CleanArcViewModel(private val interactor: CleanArcInteractor, private val text: String) : ViewModel() {

    val data: Observable<String>
        get() = interactor.data

    fun saveData(text: String) {
        interactor.saveData(text)
    }

}