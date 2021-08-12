package com.example.lessonsFromSamsung.theme23_LocalStaticInnerClasses.quest

class Act(
    val text: String,
    val answers: List<Answer> = emptyList()
) {

    class Answer(
        val text: String,
        val nextAct: Act? = null
    )

}