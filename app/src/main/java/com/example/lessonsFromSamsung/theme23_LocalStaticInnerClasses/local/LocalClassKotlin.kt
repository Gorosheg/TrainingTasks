package com.example.lessonsFromSamsung.theme23_LocalStaticInnerClasses.local

private class LocalClassKotlin {

    fun bar() {
        var someValue = 0

        class Local {

            fun foo() {
                someValue = 1;
            }

        }

        val local = Local()
    }

}