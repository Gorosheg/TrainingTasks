package com.example.lessonsFromSamsung.theme53_Examples

import kotlin.reflect.KClass

class InlineReified {

    private fun main() {
        val q = Pair(1, 2)
        log(q::class.java)
        log(q::class)
        q.log()
    }

    private fun log(clazz: Class<*>) {
        println(clazz.name)
    }

    private fun log(clazz: KClass<*>) {
        println(clazz.java.name)
    }

    private inline fun <reified T : Any> T.log() {
        println(this::class.java.name) // рефлексия
        println(this::class.typeParameters.first().name)
    }

}