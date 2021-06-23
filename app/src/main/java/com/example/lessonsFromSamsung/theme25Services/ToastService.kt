package com.example.lessonsFromSamsung.theme25Services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class ToastService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this,"Everything is OK!", Toast.LENGTH_SHORT).show()
        stopSelf()
    }
}