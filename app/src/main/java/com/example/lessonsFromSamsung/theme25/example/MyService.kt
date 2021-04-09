package com.example.lessonsFromSamsung.theme25.example

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import com.example.lessonsFromSamsung.theme25.example.NotificationManager.Companion.NOTIFICATION_ID

// Это (форграунд) сервис, который отображает натификацию
class MyService : Service() {

    // Создаем переменную notificationManager, который определим позже
    private lateinit var notificationManager: NotificationManager

    override fun onCreate() {
        super.onCreate()

        // applicationContext останется после завершения активити
        notificationManager = NotificationManager(applicationContext)

        // Запуск форграунд сервиса
        startForeground(NOTIFICATION_ID, notificationManager.updateNotification("Аня классная!"))
    }

    // Нужно всегда
    override fun onBind(intent: Intent?): Nothing? = null

    // START_STICKY описывает стандартное поведение сервиса при повторном запуске.
    // Обработчик onStartCommand() будет вызываться при повторном запуске сервиса
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int) = START_STICKY

    // Уничтожение сервиса и нотификации
    override fun onDestroy() {
        stopForeground(true)
        super.onDestroy()
    }

    companion object {

        // Создание интента для работы с сервисом
        private val Context.serviceIntent
            get() = Intent(this, MyService::class.java)

        // Запуск сервиса
        fun Activity.startMyService() {
            startService(serviceIntent)
        }

        // Остановка сервиса
        fun Context.stopMyService() {
            stopService(serviceIntent)
        }

    }

}