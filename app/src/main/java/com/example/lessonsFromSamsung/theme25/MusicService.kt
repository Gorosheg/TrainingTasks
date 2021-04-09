package com.example.lessonsFromSamsung.theme25

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.example.lessonsFromSamsung.R

class MusicService : Service() {

    private lateinit var player: MediaPlayer
    private var totalTime = 0

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this, R.raw.akeboshi_wind)
        player.isLooping = true
        totalTime = player.duration
        player.start()
    }

    override fun onDestroy() {
        player.pause()
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    companion object {

        private val Context.serviceIntent
            get() = Intent(this, MusicService::class.java)

        fun Activity.startLightService() {
            startService(serviceIntent)
        }

        fun Context.stopLightService() {
            stopService(serviceIntent)
        }

    }

}
