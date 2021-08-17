package com.example.lessonsFromSamsung.theme49_ClientServerArchitecture

import com.google.gson.annotations.SerializedName

class CatFact {
    class Weather(
        @SerializedName("id")
        private val id: String,

        @SerializedName("text")
        private val text: String,

        @SerializedName("data")
        private val degrees: String
    )
}