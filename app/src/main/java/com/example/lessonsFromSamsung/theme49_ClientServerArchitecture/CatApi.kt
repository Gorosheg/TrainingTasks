package com.example.lessonsFromSamsung.theme49_ClientServerArchitecture

import retrofit2.Call
import retrofit2.http.GET

interface CatApi {
    @GET("/facts/random")
    fun getRandomFact(): Call<CatFact>
}