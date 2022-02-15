package com.example.lessonsFromSamsung.theme53_Examples.lambda

private interface SumCalculator1 /*: (Int, Int) -> Int*/  {

    fun calculate(x: Int, y: Int): Int
}

private class A1 : SumCalculator1 {

    init {
        val b = B1(this)
        b.doLogic()
    }

    override fun calculate(x: Int, y: Int): Int {
        return x + y
    }
}

private class B1(private val sumCalculator: SumCalculator1) {

    fun doLogic() {
        val x = 1
        val y = 1

        val sum = sumCalculator.calculate(x, y)
    }
}