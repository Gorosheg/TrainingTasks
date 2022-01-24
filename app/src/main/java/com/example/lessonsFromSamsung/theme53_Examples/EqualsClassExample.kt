package com.example.lessonsFromSamsung.theme53_Examples

private class EqualsClassExample(
    val param1: Int,
    val param2: Char,
    val param3: String,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EqualsClassExample

        if (param1 != other.param1) return false
        if (param2 != other.param2) return false
        if (param3 != other.param3) return false

        return true
    }

    override fun hashCode(): Int {
        var result = param1
        result = 31 * result + param2.hashCode()
        result = 31 * result + param3.hashCode()
        return result
    }

}

private fun main() {
    val first = EqualsClassExample(param1 = 1, param2 = 'a', param3 = "John")
    val second = EqualsClassExample(param1 = 1, param2 = 'a', param3 = "John")
    val compareByLink = first === second
    val compareByContent = first == second

    val firstHashCode = first.hashCode()
    val secondHashCode = second.hashCode()

    println("По ссылке: $compareByLink")
    println("По знач: $compareByContent")
    println("Первый хеш-код: $firstHashCode")
    println("Второй хеш-код: $secondHashCode")
    println(firstHashCode == secondHashCode)
}
