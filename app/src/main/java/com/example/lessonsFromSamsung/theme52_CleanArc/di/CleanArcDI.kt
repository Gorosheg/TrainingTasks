package com.example.lessonsFromSamsung.theme52_CleanArc.di

import com.example.lessonsFromSamsung.theme52_CleanArc.data.CleanArcRepository
import com.example.lessonsFromSamsung.theme52_CleanArc.data.CleanArcRepositoryImpl
import com.example.lessonsFromSamsung.theme52_CleanArc.domain.CleanArcInteractor
import com.example.lessonsFromSamsung.theme52_CleanArc.domain.CleanArcInteractorImpl

class CleanArcDI {

    val interactor: CleanArcInteractor
        get() = CleanArcInteractorImpl(repository)

    private val repository: CleanArcRepository
        get() = CleanArcRepositoryImpl()

}