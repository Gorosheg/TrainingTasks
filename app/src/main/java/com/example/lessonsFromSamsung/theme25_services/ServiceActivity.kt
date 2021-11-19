package com.example.lessonsFromSamsung.theme25_services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme25_services.MusicService.Companion.startMusicService
import com.example.lessonsFromSamsung.theme25_services.example.NotificationManager.Companion.CHANNEL_ID
import kotlinx.android.synthetic.main.activity_theme_25_service.*

class ServiceActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var light: Sensor

    private var serviceStarted = false

    private val playerHolder = MusicPlayHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        createNotificationChannel()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_25_service)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        startMusicService()
        //    setNotificationButtonClickListener()
    }

    override fun onStart() {
        super.onStart()
        registerSensorManagerListener()
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val values = event?.values ?: return
        val lightCounter = values[0].toInt()
        val isNight = lightCounter < 5
//        values.forEach { println("qwerty $it") }

        if (!serviceStarted && isNight) {
            println("qwerty serviceStarted!")
            serviceStarted = true

            // Вызываем функцию play playerHolder'а
            playerHolder.play()
        } else if (serviceStarted && !isNight) {
            println("qwerty serviceStopped!")
            serviceStarted = false

            // Вызываем функцию pause playerHolder'а, в который колбек приходит из сервиса
            playerHolder.pause()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    private fun setNotificationButtonClickListener() {
        notificationButton.setOnClickListener {
            startToastService()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return

        val name = getString(R.string.app_name)

        val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT).apply {
            setShowBadge(false)
            lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        }

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun startToastService() {
        val intent = Intent(this, ToastService::class.java)
        startService(intent)
    }

    private fun registerSensorManagerListener() {
        sensorManager.registerListener(
            this,
            light,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

}