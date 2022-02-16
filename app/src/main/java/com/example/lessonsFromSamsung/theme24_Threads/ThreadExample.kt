package com.example.lessonsFromSamsung.theme24_Threads

fun main() {
  val chickenVoice = ChickenVoice()
    chickenVoice.dispute()
}

private class EggVoice : Thread() {
    override fun run() {
        for (i in 0..4) {
            try {
                sleep(1000) //Приостанавливает поток на 1 секунду
            } catch (e: InterruptedException) {
            }
            println("яйцо!")
        }
        //Слово «яйцо» сказано 5 раз
    }
}

 private class ChickenVoice {

     fun dispute() {
        val mAnotherOpinion = EggVoice() //Создание потока
        println("Спор начат...")
        mAnotherOpinion.start() //Запуск потока

        for (i in 0..4) {
            try {
                Thread.sleep(1000) //Приостанавливает поток на 1 секунду
            } catch (e: InterruptedException) {
            }
            println("курица!")
        }
        //Слово «курица» сказано 5 раз

        if (mAnotherOpinion.isAlive) { //Если оппонент еще не сказал последнее слово
            try {
                mAnotherOpinion.join() //Подождать пока оппонент закончит высказываться.
            } catch (e: InterruptedException) {
            }
            println("Первым появилось яйцо!")
        } else { //если оппонент уже закончил высказываться
            println("Первой появилась курица!")
        }
        println("Спор закончен!")
    }
}