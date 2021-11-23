package com.example.lessonsFromSamsung.theme50_RXJava

import android.content.ContentValues.TAG
import android.util.Log
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

/*
observable - ветки: onNext, onError, onComplete
flowable - ветки: onNext, onError, onComplete - То же что и observable, но если поток данных более 1000 в сек.
single - ветки: OnSuccess, onError
maybe  - ветки: OnSuccess, onError, onComplete
completable - ветки: onError, onComplete
*/


// Источники данных
val observable = Observable.just(1, 2, 3)
val single = Single.just(1)
val flowable = Flowable.just(1, 2, 3)

// Подписчики
val subscriber = observable.subscribe {
    Log.e(TAG, "new data $it")
}

val subscriber2 = single.subscribe({
// OnSuccess
    Log.e(TAG, "new data $it")
}, {
// onError
})

val subscriber3 = flowable.subscribe({
    Log.e(TAG, "new data $it")
}, {

})


val observable2 = Observable.just("Алексей", "Иван", "Владимир") // Создание данных

val subscriber4: Disposable = observable2
    .map { name: String -> name + "Владимирович" } // Изменение данных
    .map { nameAndSurname: String -> nameAndSurname + 30 } // Значение приводится к тому же типу, что был на входе
    .map { nameSurnameAndAge: String ->
        if (nameSurnameAndAge.contains("a")) {
            "$nameSurnameAndAge A"
        } else {
            "$nameSurnameAndAge Нет A"
        }
    }
    // flatMap создает новый объект Observable.
    // Если обработка данных будет занимать много времени, они могут отобразиться в другом порядке,
    // т.к. flatMap возвращает значения по мере их готовности, а не в том же порядке, в каком они были изначально
    .flatMap {
        val delay = Random().nextInt(10)
        Observable.just(it).delay(delay.toLong(), TimeUnit.SECONDS)
    }
    // concatMap Выводит все значения последовательно, несмотря на задержку
    .concatMap {
        val delay = Random().nextInt(10)
        Observable.just(it).delay(delay.toLong(), TimeUnit.SECONDS)
    }
    .switchMap {
        val delay = Random().nextInt(10)
        Observable.just(it).delay(delay.toLong(), TimeUnit.SECONDS)
    }
    .buffer(2) // Преобразовывает в листы стрингов по 2 штуки
    .subscribe { println(it) } // Подписка


val dispose: Disposable = dataSource()
    .subscribeOn(Schedulers.newThread()) // Запуск нового потока
    .observeOn(AndroidSchedulers.mainThread()) // Возвращает задачу в main поток
//            .doOnNext {  }
//            .doOnError {  }
//            .doOnComplete {  }
    // В этой ветке код отработает, если программа выполнится успешно (onNext)
    .subscribe({
        Log.e(TAG, "next Int $it")
    }, {
        // код отработает при ошибке(onError)
    }, {
        //(onComplete)
    })

val dispose2 = dataSource2()
    //  .doOnSuccess {  }
    .subscribeOn(Schedulers.computation()) //
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({
        val first = it.first()
    }, {

    })


private fun dataSource(): Observable<Int> {
    return Observable.create { subscriber ->
        for (i in 0..100) {
            Thread.sleep(1000)
            subscriber.onNext(i) // Передает подписчикам "i" в ветку onNext
        }

        subscriber.onComplete()
    }
}

private fun dataSource2(): Single<List<Int>> {
    return Single.create { subscriber ->
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        subscriber.onSuccess(list)
    }
}

private fun dataSource3(): Flowable<Int> {
    return Flowable.create({ subscriber ->
        for (i in 0..100) {
            Thread.sleep(1000)
            subscriber.onNext(i) // Передает подписчикам "i" в ветку onNext
        }
        subscriber.onComplete()
    }, BackpressureStrategy.DROP) // Стратегия обработки данных, которые пришли слишком быстро.
}
/*
    Варианты:
    MISSING - подписчик сам будет справляться с переполнением.
    BUFFER - данные будут складываться в буфер, потом в основную очередь, чтобы они  не потерялись.
    DROP - отбрасывает последнее значение
    ERROR - выбрасывает exception
    LATEST - сохраняет только последнее значение onNext, перезаписывая любое предыдущее значение.
    */