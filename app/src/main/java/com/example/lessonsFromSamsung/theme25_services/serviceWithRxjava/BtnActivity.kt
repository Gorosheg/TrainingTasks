package com.example.lessonsFromSamsung.theme25_services.serviceWithRxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.main.App
import com.example.lessonsFromSamsung.theme25_services.serviceWithRxjava.NotificationRxService.Companion.startRxService
import com.example.lessonsFromSamsung.theme25_services.serviceWithRxjava.NotificationRxService.Companion.stopRxService
import kotlinx.android.synthetic.main.activity_theme_25_btn.*


class BtnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_25_btn)

        startRxService()

        btnService.setOnClickListener {
            App.myExampleData.subject.onNext(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopRxService()
    }
}
