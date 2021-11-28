package com.example.lessonsFromSamsung.theme52_CleanArc.presentation

import androidx.lifecycle.ViewModel
import com.example.lessonsFromSamsung.main.App
import com.example.lessonsFromSamsung.theme52_CleanArc.domain.CleanArcInteractor
import io.reactivex.Observable

class CleanArcViewModel : ViewModel() {

    private val interactor: CleanArcInteractor by lazy { App.cleanArcDI.interactor }

    val data: Observable<String>
        get() = interactor.data

    fun saveData(text: String) {
        interactor.saveData(text)
    }

}