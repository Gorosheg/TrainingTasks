package com.example.lessonsFromSamsung.theme23LocalStaticInnerClasses.quest

import com.example.lessonsFromSamsung.utils.scanner

private val act1AC = Act(
    text = "Не делать ничего",
    answers = listOf(
        Act.Answer(text = "1. Поесть", nextAct = Act(text = "Вы уснули...")),
        Act.Answer(text = "2. Посмотреть тикток", nextAct = Act(text = "Вы отупели"))
    )
)
private val act1AB = Act(
    text = "Делать уроки для основной школы",
    answers = listOf(
        Act.Answer(
            text = "1. Отказаться от выполнения уроков и лечь спать",
            nextAct = Act(text = "Вы уснули...")
        ),
        Act.Answer(
            text = "2. Вспомнить, что завтра экзамен по физике и начать делать её",
            nextAct = Act(text = "Вы успешно сдали экзамен по физике, но пропустили тему в Samsung")
        )
    )
)

private val act1AA = Act(
    text = "Изучить презентацию",
    answers = listOf(
        Act.Answer(
            text = "1. Не найти ссылку",
            nextAct = Act(text = "Вы отстали от программы")
        ),
        Act.Answer(
            text = "2. Не найти презентацию",
            nextAct = Act(text = "Ох уж эти ваши отмазки")
        ),
        Act.Answer(
            text = "3. Изучить, но все забыть",
            nextAct = Act(text = "Вы, оказывается, не очень-то умный...")
        )
    )
)

private val act1C = Act(
    text = "Пойти на каток",
    answers = listOf(
        Act.Answer(
            text = "1. Пойти всей семьей",
            nextAct = Act(text = "Было весело, но вы пропустили тему в Samsung")
        ),
        Act.Answer(
            text = "2. Пойти одному",
            nextAct = Act(text = "Вы интроверт, который пропустил тему в Samsung")
        ),
        Act.Answer(
            text = "3. С друзьями",
            nextAct = Act(text = "Было весело, но вы пропустили тему в Samsung")
        )
    )
)

private val act1B = Act(
    text = "Добраться до школы",
    answers = listOf(
        Act.Answer(
            text = "1. Поехать на автобусе",
            nextAct = Act(text = "Вы получили новые знания, поздравляю, это победа!")
        ),
        Act.Answer(
            text = "2. Пойти пешком",
            nextAct = Act(text = "Вы опоздали и пропустили тему в Samsung")
        )
    )
)

private val act1A = Act(
    text = "Надо изучить презентацию",
    answers = listOf(
        Act.Answer(text = "1. Изучить презентацию", nextAct = act1AA),
        Act.Answer(text = "2. Делать уроки для основной школы", nextAct = act1AB),
        Act.Answer(text = "3. Не делать ничего", nextAct = act1AC)
    )
)

private val act1 = Act(
    text = "Надо идти в Samsung школу",
    answers = listOf(
        Act.Answer(text = "1. Остаться дома", nextAct = act1A),
        Act.Answer(text = "2. Пойти в школу", nextAct = act1B),
        Act.Answer(text = "3. Пойти гулять", nextAct = act1C)
    )
)

private fun main() {
    showAct(act1)
}

fun showAct(act: Act) {
    println(act.text)

    act.answers.forEach {
        println(it.text)
    }

    // Тоже самое можно написать используя ссылку на функцию
//    act.answers
//        .map(Act.Answer::text)
//        .forEach(::println)

    if (act.answers.isNotEmpty()) {
        val selectedAnswerIndex = scanner.nextInt() - 1

        act.answers[selectedAnswerIndex]
            .nextAct
            ?.let(::showAct)
    }
}