package com.example.lessonsFromSamsung.theme25_services.serviceWithRxjava

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.example.lessonsFromSamsung.main.App
import com.example.lessonsFromSamsung.theme25_services.example.NotificationManager

class NotificationRxService : Service() {

    private lateinit var notificationManager: NotificationManager

    override fun onCreate() {
        super.onCreate()

        notificationManager = NotificationManager(applicationContext)

        val a = App.myExampleData.subject.subscribe {
            startForeground(NotificationManager.NOTIFICATION_ID, notificationManager.updateNotification("Btn clicked!"))
        }

    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int) = START_STICKY

    override fun onDestroy() {
        stopForeground(true)
        super.onDestroy()
    }


    companion object {

        private val Context.serviceIntent
            get() = Intent(this, NotificationRxService::class.java)

        fun Activity.startRxService() {
            startService(serviceIntent)
        }
        fun Context.stopRxService() {
            stopService(serviceIntent)
        }
    }

}