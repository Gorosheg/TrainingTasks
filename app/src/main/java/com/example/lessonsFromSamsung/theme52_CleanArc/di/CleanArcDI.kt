package com.example.lessonsFromSamsung.theme52_CleanArc.di

import com.example.lessonsFromSamsung.theme52_CleanArc.data.CleanArcRepository
import com.example.lessonsFromSamsung.theme52_CleanArc.data.CleanArcRepositoryImpl
import com.example.lessonsFromSamsung.theme52_CleanArc.domain.CleanArcInteractor
import com.example.lessonsFromSamsung.theme52_CleanArc.domain.CleanArcInteractorImpl
import com.example.lessonsFromSamsung.theme52_CleanArc.presentation.CleanArcViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// Связывает Repository с Interactor-ом, создает ViewModel
val cleanModule = module {
    viewModel { params ->
        CleanArcViewModel(
            interactor = get { params }, // Прокидываем параметры дальше
            number = params.get() // в качестве аргумента забираем первый (можно так: component1())
        )
    }

    factory<CleanArcInteractor> { params ->
        CleanArcInteractorImpl(get { params }) // Прокидываем параметры дальше
    }

    factory<CleanArcRepository> { params ->
        CleanArcRepositoryImpl(params.get()) // Достаем нужный параметр
    }

    /* single<CleanArcRepository> { (_: String, number: Int) -> // Разворачиваем дата класс через компоненты
        CleanArcRepositoryImpl(number)
    }*/
}