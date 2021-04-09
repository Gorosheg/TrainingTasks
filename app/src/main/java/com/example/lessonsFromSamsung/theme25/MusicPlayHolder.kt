package com.example.lessonsFromSamsung.theme25

// Это класс (singleton) у которого всегда только один экземпляр
object MusicPlayHolder {

    // Принимает колбек из сервиса
    var playCallback: () -> Unit = {}

    var pauseCallback: () -> Unit = {}

    fun play() {
        // Вызываем колбэк
        playCallback.invoke()
    }

    fun pause() {
        pauseCallback.invoke()
    }

}