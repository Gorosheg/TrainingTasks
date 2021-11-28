package com.example.lessonsFromSamsung.theme52_CleanArc.presentation

import androidx.lifecycle.ViewModel
import com.example.lessonsFromSamsung.theme52_CleanArc.domain.SaveUseCase
import com.example.lessonsFromSamsung.theme52_CleanArc.domain.ShowUseCase
import io.reactivex.Observable

class MyViewModel(
    private val showUseCase: ShowUseCase,
    private val saveUseCase: SaveUseCase
) : ViewModel() {


    lateinit var _error: Observable<Boolean>
    val error = _error


    fun saveData(text: String) {
        _error = saveUseCase.saveData(text)
    }

    fun getData(): Observable<String> {
        return showUseCase.showData()
    }
}