package com.example.lessonsFromSamsung.theme52_SharedPreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsFromSamsung.R

// Создать отдельный класс, вызывать из репозитория
class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_52_shared_preferences)
// В DI создавать
        val sharedPref: SharedPreferences = getSharedPreferences(
            MY_SETTINGS,  // Название таблицы
            Context.MODE_PRIVATE  // Модификатор доступа?
        )
        // проверяем, первый ли раз открывается программа
        val firstVisit = sharedPref.getBoolean(VISITED, false) // (ключ, значение)

        if (!firstVisit) {
            toast()
            // После этой команды можно редактировать таблицу
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.putBoolean(VISITED, true)
            editor.apply() // После этой команды изменения сохраняются (или commit())
        }

    }

    private fun toast() {
        Toast.makeText(this, "first opening", Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val MY_SETTINGS = "my_settings"
        private const val VISITED = "hasVisited"
    }

}