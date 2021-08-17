package com.example.lessonsFromSamsung.theme49_ClientServerArchitecture

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkManager {
    private var api: CatApi? = null

    fun api(): CatApi? {
        if (api == null) { // Инициализируем api только один раз при вызове. Реализация паттерна singleton
            val okHttpClient = OkHttpClient().newBuilder() // Создаем okHttpClient
                .connectTimeout(10, TimeUnit.SECONDS) // Время на соединение с сервером
                .readTimeout(15, TimeUnit.SECONDS) // Время на чтение запроса
                .build() // Собираем okHttpClient

            api = Retrofit.Builder() // Реализация паттерна Builder
                .client(okHttpClient) // Клиентом является okHttpClient
                .addConverterFactory(GsonConverterFactory.create()) // Преобразуем json формат в читабельные классы
                .baseUrl("https://evilinsult.com/") // Базовый путь до api (backend)
                .build() // Собираем Retrofit
                .create(CatApi::class.java) // Передаем интерфейс, который Retrofit сам реализует
        }

        return api
    }

}