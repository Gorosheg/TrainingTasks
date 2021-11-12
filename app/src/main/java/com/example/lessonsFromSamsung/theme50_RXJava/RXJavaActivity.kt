package com.example.lessonsFromSamsung.theme50_RXJava

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_theme_50_rxjava.*

/*
observable - ветки: onNext, onError, onComplete
flowable - ветки: onNext, onError, onComplete - То же что и observable, но если поток данных более 1000 в сек.
single - ветки: OnSuccess, onError
maybe  - ветки: OnSuccess, onError, onComplete
completable - ветки: onError, onComplete
*/

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
        // OnSuccess
             Log.e(TAG, "new data $it")
         }, {
        // onError
         })*/

        /*val subscriber = flowable.subscribe({
            Log.e(TAG, "new data $it")
        }, {

        })
        */

        btnTest.setOnClickListener {
            Toast.makeText(applicationContext, "Click", Toast.LENGTH_SHORT).show()
        }

        val dispose: Disposable = dataSource()
            .subscribeOn(Schedulers.newThread()) // Запуск нового потока
            .observeOn(AndroidSchedulers.mainThread()) // Возвращает задачу в main поток
            // В этой ветке код отработает, если программа выполнится успешно (onNext)
            .subscribe({
                btnTest.text = "Next int $it"
                Log.e(TAG, "next Int $it")
            }, {
                // код отработает при ошибке(onError)
            }, {
                //(onComplete)
            })

        /*  val dispose = dataSource()
              //  .doOnSuccess {  }
              .subscribeOn(Schedulers.computation())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe({
                  val first = it.first()
              }, {

              })*/

    }


    private fun dataSource(): Observable<Int> {
        return Observable.create { subscriber ->
            for (i in 0..100) {
                Thread.sleep(1000)
                subscriber.onNext(i) // Передает подписчикам "i" в ветку onNext
            }

            subscriber.onComplete()
        }
    }

/*  private fun dataSource(): Single<List<Int>> {
        return Single.create { subscriber ->
            val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
            subscriber.onSuccess(list)
    }
}*/

/*
    private fun dataSource(): Flowable<Int> {
        return Flowable.create({ subscriber ->
            for (i in 0..100) {
            Thread.sleep(1000)
            subscriber.onNext(i) // Передает подписчикам "i" в ветку onNext
        }
        subscriber.onComplete()
    }, BackpressureStrategy.DROP) // Стратегия обработки данных, которые пришли слишком быстро.

    Варианты:
    MISSING - подписчик сам будет справляться с переполнением.
    BUFFER - данные будут складываться в буфер, потом в основную очередь, чтобы они  не потерялись.
    DROP - отбрасывает последнее значение
    ERROR - выбрасывает exception
    LATEST - сохраняет только последнее значение onNext, перезаписывая любое предыдущее значение.
    */

}
