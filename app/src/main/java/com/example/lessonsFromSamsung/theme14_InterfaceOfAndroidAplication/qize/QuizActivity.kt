package com.example.lessonsFromSamsung.theme14_InterfaceOfAndroidAplication.qize

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.utils.setAppTextColor
import kotlinx.android.synthetic.main.activity_theme_14_questionnaire.*

class QuizActivity : AppCompatActivity() {

    private var questionCounter = 0

    private val questions: List<Question> by lazy { buildQuestions() } // Ленивая инициализация значения

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_14_questionnaire)

        radioGroupQuestion.setOnCheckedChangeListener { _, radioButtonId ->
            checkAnswer(radioButtonId)
        }

        previousQuestion.setOnClickListener { renderPreviousQuestion() }
        nextQuestion.setOnClickListener { renderNextQuestion() }
        startAgain.setOnClickListener { renderFirstQuestion() }

        renderQuestion()
    }

    private fun buildQuestions(): List<Question> {
        return listOf(
            Question(
                question = getString(R.string.potato_question),
                firstAnswer = 15.toString(),
                secondAnswer = 5.toString(),
                rightAnswerId = 0
            ),
            Question(
                question = getString(R.string.calculation_numbers_question),
                firstAnswer = "2, 3, 5",
                secondAnswer = "1, 2, 3",
                rightAnswerId = 1
            ),
            Question(
                question = getString(R.string.months_question),
                firstAnswer = getString(R.string.third_question_answer_one),
                secondAnswer = getString(R.string.third_question_answer_two),
                rightAnswerId = 1
            )
        )
    }

    private fun checkAnswer(radioButtonId: Int) {
        val question = questions[questionCounter]

        if (radioButtonId == R.id.firstVariant && question.rightAnswerId == 0 ||
            radioButtonId == R.id.secondVariant && question.rightAnswerId == 1
        ) {
            rightAnswer()
        } else {
            wrongAnswer()
        }
    }

    private fun rightAnswer() {
        answerResult.text = "Верно"
        answerResult.setAppTextColor(R.color.positive)
    }

    private fun wrongAnswer() {
        answerResult.text = "Не верно"
        answerResult.setAppTextColor(R.color.negative)
    }

    private fun renderPreviousQuestion() {
        questionCounter--
        radioGroupQuestion.clearCheck()
        renderQuestion()
        startAgain.isVisible = false
        previousQuestion.isEnabled = true
        nextQuestion.isEnabled = true

        if (questionCounter == 0) {
            previousQuestion.isEnabled = false
        }
    }

    private fun renderNextQuestion() {
        questionCounter++
        radioGroupQuestion.clearCheck()
        renderQuestion()
        previousQuestion.isEnabled = true

        if (questionCounter == questions.size - 1) {
            nextQuestion.isEnabled = false
            startAgain.isVisible = true
        }
    }

    private fun renderFirstQuestion() {
        questionCounter = 0
        radioGroupQuestion.clearCheck()
        renderQuestion()

        previousQuestion.isEnabled = false
        startAgain.isVisible = false
        nextQuestion.isEnabled = true
    }

    private fun renderQuestion() {
        renderQuestion(questions[questionCounter])
        answerResult.text = ""
    }

    private fun renderQuestion(question: Question) {
        questionText.text = question.question
        firstVariant.text = question.firstAnswer
        secondVariant.text = question.secondAnswer
    }


    private fun visibilityExample() {
        val isVisible = startAgain.isVisible

        startAgain.visibility = View.VISIBLE // Can be VISIBLE / GONE / INVISIBLE. Old construction
        startAgain.isVisible = false // VISIBLE / GONE
        startAgain.isGone = true //  GONE / VISIBLE
        startAgain.isInvisible = true //  INVISIBLE / VISIBLE
    }

}