package com.example.lessonsFromSamsung.theme51_MVP_Example

class MyPresenter(
    private val view: MVPInterface,
    private val db: MVPDbExample = MVPDbExample() // Прокидываем через di
) {

    fun sendMessage() {
        view.showMessage(db.takeMessage())
    }

}