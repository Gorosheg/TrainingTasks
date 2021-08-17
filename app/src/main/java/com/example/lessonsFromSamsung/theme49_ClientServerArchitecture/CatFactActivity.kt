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
        val request = object : Callback<CatFact> { // Создаем запрос, реализуя анонимный класс

            /**
             * Сюда приходит пололжительный результат
             * Серриалзация - перобразование класса в (строку/массив байт)
             * Дессерриализация - наоборот
             */
            override fun onResponse(call: Call<CatFact>, response: Response<CatFact>) {
                val fact: CatFact? = response.body()
                text.text = fact?.text
            }

            /**
             * this здесь - это Callback<CatFact>.
             * Чтобы вызвать контекст класса, который находиться выше, надо писать через "@"
             */
            override fun onFailure(call: Call<CatFact>, t: Throwable) { // Сюда приходят ошибки
                Toast.makeText(this@CatFactActivity, t.message, Toast.LENGTH_LONG).show()
                t.printStackTrace() // Ошибка печатается в логах как Warning
            }

        }

        NetworkManager.api() // Вызов api, статической функции в объекте
            ?.getRandomFact() // Вызов функции из интерфейса, который реализует ретрофит
            ?.enqueue(request) // Ассинхронный запуск запроса
    }
}