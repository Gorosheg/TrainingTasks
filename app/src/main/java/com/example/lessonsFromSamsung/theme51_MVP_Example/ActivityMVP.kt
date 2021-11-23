package com.example.lessonsFromSamsung.theme51_MVP_Example

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import kotlinx.android.synthetic.main.activity_mvp.*

class ActivityMVP : AppCompatActivity(), MVPInterface {

    lateinit var presenrer: MyPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        presenrer = MyPresenter(this)

        showDataBtn.setOnClickListener {
            presenrer.sendMessage()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}