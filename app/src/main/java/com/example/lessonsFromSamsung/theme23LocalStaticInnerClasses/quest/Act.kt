package com.example.lessonsFromSamsung.theme23LocalStaticInnerClasses.quest

class Act(
    val text: String,
    val answers: List<Answer> = emptyList()
) {

    class Answer(
        val text: String,
        val nextAct: Act? = null
    )

}