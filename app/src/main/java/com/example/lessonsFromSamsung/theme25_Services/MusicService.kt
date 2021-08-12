package com.example.lessonsFromSamsung.theme25_Services

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

    private val playerHolder = MusicPlayHolder

    override fun onCreate() {
        super.onCreate()
        createPlayer()

        // Вызываем playerHolder, передаем туда колбек start
        playerHolder.playCallback = {
            player.start()
        }

        // Вызываем playerHolder, передаем туда колбек pause
        playerHolder.pauseCallback = {
            player.pause()
        }
    }

    private fun createPlayer() {
        player = MediaPlayer.create(this, R.raw.akeboshi_wind)
        player.isLooping = true
        totalTime = player.duration
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

        fun Activity.startMusicService() {
            startService(serviceIntent)
        }

        fun Context.stopMusicService() {
            stopService(serviceIntent)
        }

    }

}
