package com.example.lessonsFromSamsung.theme52_CleanArc.data

import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

class CleanArcRepositoryImpl(number: Int) : CleanArcRepository {
    override val data: Subject<String> = BehaviorSubject.create()

    override fun saveData(text: String) {
        data.onNext(text)
    }

}