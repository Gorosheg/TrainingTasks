package com.example.lessonsFromSamsung.theme25_services.serviceWithRxjava

import io.reactivex.subjects.PublishSubject

class MyExampleData {

    val subject = PublishSubject.create<Boolean>()

}
