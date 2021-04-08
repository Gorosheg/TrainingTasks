package com.example.lessonsFromSamsung.theme25

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
import com.example.lessonsFromSamsung.theme25.example.MyService
import com.example.lessonsFromSamsung.theme25.example.NotificationManager.Companion.CHANNEL_ID
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var lightning: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        createNotificationChannel()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        lightning = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        setNotificationButtonClickListener()

        val intent = Intent(this, MyService::class.java)
        startService(intent)

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
        val value = event?.values ?: return
//тут музыка должна включаться/выключаться
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
            LightService,
            lightning,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

}