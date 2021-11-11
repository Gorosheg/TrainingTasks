package com.example.lessonsFromSamsung.theme50_RXJava

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

class RXJavaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_50_rxjava)


        // Источники данных
        val observable = Observable.just(1, 2, 3)
        val single = Single.just(1)
        val flowable = Flowable.just(1, 2, 3)

        // Подписчики
        /*val subscriber = observable.subscribe {
            Log.e(TAG, "new data $it")
        }*/

        /* val subscriber = single.subscribe({
             Log.e(TAG, "new data $it")
         }, {

         })*/

        /*val subscriber = flowable.subscribe({
            Log.e(TAG, "new data $it")
        }, {

        })*/

        val dispose = dataSource()
            .subscribe({
                Log.e(TAG, "next Int $it")
            }, {

            }, {

            })

    }

    fun dataSource(): Observable<Int> {
        return Observable.create { subscriber ->
            for (i in 0..100) {
                Thread.sleep(1000)
                subscriber.onNext(i)
            }
        }
    }

}