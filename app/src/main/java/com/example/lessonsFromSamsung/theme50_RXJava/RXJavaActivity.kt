package com.example.lessonsFromSamsung.theme50_RXJava

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import kotlinx.android.synthetic.main.activity_theme_50_rxjava.*
import java.util.concurrent.TimeUnit

class RXJavaActivity : AppCompatActivity() {

    private var disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_50_rxjava)


        btnTest.setOnClickListener {
            Toast.makeText(applicationContext, "Click", Toast.LENGTH_SHORT).show()
        }

        disposable += Observable.interval(1000, TimeUnit.MILLISECONDS)
            .filter {
                (it == 1L || it == 2L || it == 3L || it == 5L || it == 7L || it == 9L ||
                        naturalNumbersBiggerThanTen(it))
            }
            .subscribe { btnTest.text = "$it" }

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun naturalNumbersBiggerThanTen(it: Long) = it % 2 != 0L &&
            it % 3 != 0L &&
            it % 5 != 0L &&
            it % 7 != 0L &&
            it % 9 != 0L
}