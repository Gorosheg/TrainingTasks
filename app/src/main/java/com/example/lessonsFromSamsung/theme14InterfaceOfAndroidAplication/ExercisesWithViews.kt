package com.example.lessonsFromSamsung.theme14InterfaceOfAndroidAplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.utils.setAppTextColor
import kotlinx.android.synthetic.main.activity_theme_14.*

class ExercisesWithViews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { // Метод жизненного цикла
        super.onCreate(savedInstanceState) // Вызываем метод onCreate у базового класса. Делать это обязательно
        setContentView(R.layout.activity_theme_14) // Приаттачиваем layout к активити

        sumTwoNumbers()
        counterOfClicks()
        showResultOfQuestion()
    }

    private fun showResultOfQuestion() {
        radioGroupQuestion.setOnCheckedChangeListener { _, i ->
            // Создание анонимного класса. Ниже такая же штука только через лямбду
            nextQuestion.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) { /* Your code here */ }
            })

            nextQuestion.setOnClickListener {
                if (i == R.id.radioNo) {
                    wrongAnswer()
                } else {
                    rightAnswer()
                }
            }
        }
    }

    private fun wrongAnswer() {
        answer.text = "Вредина"
        answer.setAppTextColor(R.color.negative)
    }

    private fun rightAnswer() {
        answer.text = "Я тебя тоже"
        answer.setTextColor(ContextCompat.getColor(this, R.color.positive))
    }

    private fun sumTwoNumbers() {
        editFirstNumber.doAfterTextChanged {
            writeTheSumToAnswer()
        }

        editSecondNumber.doAfterTextChanged {
            writeTheSumToAnswer()
        }
    }

    private fun writeTheSumToAnswer() {
        sumAnswer.text = sumEditTexts(editFirstNumber, editSecondNumber).toString()
    }

    private fun sumEditTexts(firstEditText: EditText, secondEditText: EditText): Int {
        val firstValue = firstEditText.toInt()
        val secondValue = secondEditText.toInt()
        return firstValue + secondValue
    }

    /**
     * Функция-расширение - extension
     * Первый аргумент переходит в ресивер
     * В java: toInt(receiver: EditText): Int
     */
    private fun EditText.toInt(): Int {
        val text = text.toString()
        if (text.isEmpty()) return 0
        return text.toInt()
    }


    private fun counterOfClicks() {
        var counter = 0

        buttonPlus.setOnClickListener {
            counter++
            applyCounter(counter)
        }

        buttonClear.setOnClickListener {
            counter = 0
            applyCounter(counter)
        }
    }

    private fun applyCounter(counter: Int) {
        zero.text = counter.toString()
    }


    private fun example() {
        // Legacy findViewById
        val textView: TextView = findViewById(R.id.textView)

        // Just call "button"
        applyButton.setOnClickListener { // Наш callback, lambda, штука которая вызывается когда что-то произошло (клик на кнопку)
            val myText = editText.text.toString()
            textView.text = myText
        }

        checkBox.setOnCheckedChangeListener { _, isChecked -> // Здесь в лямбду нам приходит 2 параметра CompoundButton и boolean. CompoundButton переименовываем в _ т.к. не используем
            if (isChecked) textView.text = getString(R.string.checkbox_checked)
            else textView.text = getString(R.string.checkBox_unchecked)
        }
    }


    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    companion object {

    }

}