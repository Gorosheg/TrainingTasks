package com.example.lessonsFromSamsung.theme49_ClientServerArchitecture

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R
import kotlinx.android.synthetic.main.activity_theme_49_cat_fact.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatFactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_49_cat_fact)

        loadFact()
    }

    private fun loadFact() {
        NetworkManager.api()?.getRandomFact()?.enqueue(object : Callback<CatFact> {
            override fun onResponse(call: Call<CatFact>, response: Response<CatFact>) {
                val fact: CatFact? = response.body()
                text.text = fact?.text
            }

            override fun onFailure(call: Call<CatFact>, t: Throwable) {
                Toast.makeText(this@CatFactActivity, t.message, Toast.LENGTH_LONG).show()
                t.printStackTrace()
            }

        })
    }
}