package com.example.lessonsFromSamsung.theme53_Examples.lambda

private class A2 {

    init {
        val b = B2(::calculate)
        b.doLogic()
    }

    fun calculate(x: Int, y: Int): Int {
        return x + y
    }
}

private class B2(private val sumCalculator: (/*x:*/ Int, /*y:*/ Int) -> Int) {

    fun doLogic() {
        val x = 1
        val y = 1

        val sum = sumCalculator.invoke(x, y)
    }
}