package com.example.lessonsFromSamsung.theme23LocalStaticInnerClasses.quest

private val act1AC = Act(
    text = " ",
    answers = listOf(
        Act.Answer(text = "А) Поесть"),
        Act.Answer(text = "B) Посмотреть тикток")
    )
)
private val act1AB = Act(
    text = " ",
    answers = listOf(
        Act.Answer(text = "А) Отказаться от выполнения уроков и лечь спать"),
        Act.Answer(text = "Вспомнить, что завтра экзамен по физике и начать делать её")
    )
)

private val act1AA = Act(
    text = " ",
    answers = listOf(
        Act.Answer(text = "А) Не найти ссылку"),
        Act.Answer(text = "B) Не найти презентацию"),
        Act.Answer(text = "C) Изучить, но все забыть")
    )
)

private val act1C = Act(
    text = "Добраться до школы.",
    answers = listOf(
        Act.Answer(text = "А) Пойти всей семьей"),
        Act.Answer(text = "B) Пойти одному"),
        Act.Answer(text = "C) С друзьями")
    )
)

private val act1B = Act(
    text = "Добраться до школы.",
    answers = listOf(
        Act.Answer(text = "А) Поехать на автобусе"),
        Act.Answer(text = "B) Пойти пешком")
    )
)


private val act1A = Act(
    text = "Надо изучить презентацию",
    answers = listOf(
        Act.Answer(text = "А) Изучить презентацию", nextAct = act1AA),
        Act.Answer(text = "B) Делать уроки для основной школы", nextAct = act1AB),
        Act.Answer(text = "C) Не делать ничего", nextAct = act1AC)
    )
)

private val act1 = Act(
    text = "Надо идти в Samsung школу",
    answers = listOf(
        Act.Answer(text = "А) Остаться дома", nextAct = act1A),
        Act.Answer(text = "Б) Пойти в школу", nextAct = act1B),
        Act.Answer(text = "В) Пойти гулять", nextAct = act1C)
    )
)

private fun main() {
    act1
}

/*
1. Надо идти в Samsung школу
А) Остаться дома. Б) Пойти в школу. В) Пойти гулять

1А) Надо изучить презентацию
А) Изучить презентацию. B) Делать уроки для основной школы. C) Не делать ничего.

1B)  Добраться до школы.
А) Поехать на автобусе. B) Пойти пешком.

1C) Пойти на каток
А) Пойти всей семьей   B) Пойти одному  C) С друзьями


1АА)  А) Не найти ссылку B) Не найти презентацию C) Изучить, но все забыть

1АB)  А) Отказаться от выполнения уроков и лечь спать  B) Вспомнить, что завтра экзамен по физике и начать делать её

1АC)  А) Поесть B) Посмотреть тикток
*/