package com.example.lessonsFromSamsung.theme52_CleanArc.data

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

class CleanArcRepositoryImpl(myText: String) : CleanArcRepository {
    override val data: Subject<String> = BehaviorSubject.create()

    override val myText: Observable<String> = Observable.just(myText)

    override fun saveData(text: String) {
        data.onNext(text)
    }

}