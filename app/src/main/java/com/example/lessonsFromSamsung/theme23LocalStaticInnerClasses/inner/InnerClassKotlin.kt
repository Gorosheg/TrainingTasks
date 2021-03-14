package com.example.lessonsFromSamsung.theme23LocalStaticInnerClasses.inner

private fun main() {
    val innerClass = InnerClassKotlin()
    val inner = innerClass.Inner()
}

private class InnerClassKotlin {

    private var someValue = 0

    private fun bar() {
        someValue = 2
    }

    inner class Inner {

        fun foo() {
            someValue = 1
        }

    }

}