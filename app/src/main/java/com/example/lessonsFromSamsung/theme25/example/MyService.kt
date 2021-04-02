package com.example.lessonsFromSamsung.theme25.example

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import com.example.lessonsFromSamsung.theme25.example.NotificationManager.Companion.NOTIFICATION_ID

class MyService : Service() {

    private lateinit var notificationManager: NotificationManager

    override fun onCreate() {
        super.onCreate()
        notificationManager = NotificationManager(applicationContext)
        startForeground(NOTIFICATION_ID, notificationManager.updateNotification())
    }

    override fun onBind(intent: Intent?): Nothing? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int) = START_STICKY

    override fun onDestroy() {
        stopForeground(true)
        super.onDestroy()
    }

    companion object {

        private val Context.serviceIntent
            get() = Intent(this, MyService::class.java)

        fun Activity.startMyService() {
            startService(serviceIntent)
        }

        fun Context.stopMyService() {
            stopService(serviceIntent)
        }

    }

}