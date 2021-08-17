package com.example.lessonsFromSamsung.theme49_ClientServerArchitecture

import retrofit2.Call
import retrofit2.http.GET

interface CatApi {

    @GET("generate_insult.php?lang=en&type=json") // Конкретный путь до запроса
    fun getRandomFact(): Call<CatFact>

}