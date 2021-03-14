package com.example.lessonsFromSamsung.theme23LocalStaticInnerClasses.inner

private fun main() {
    val staticClass = StaticClassKotlin()
    val staticC = StaticClassKotlin.Static()
}

private class StaticClassKotlin {

    private var someValue = 0

    private fun bar() {
        someValue = 2
    }

    class Static {

        fun foo() {
            // We can't use someValue
        }

    }

}