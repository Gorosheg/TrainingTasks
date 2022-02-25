package com.example.lessonsFromSamsung.theme53_Examples

/**
 * Нет конструктора
 * Все методы и поля абстрактные
 */
private interface InterfaceExample {

    val value: Int // Нельзя указать значение у переменной

    val getValue: Int
        get() = 1

    abstract fun abstractMethod()

    fun openMethod() {
        println("qwe")
    }

}

private abstract class AbstractClassExample(private val constructorValue: Int) {

    private val value: Int = 1
    abstract val abstractValue: Int
    open val openValue: Int = 1

    abstract fun abstractMethod()

    open fun openMethod() {
        println("openMethod")
    }

}

private class AbstractClassExampleImpl : AbstractClassExample(1) {

    override val abstractValue: Int = 1

    override fun abstractMethod() {
        println("abstractMethod")
    }

    override fun openMethod() {
        super.openMethod()
        println("override openMethod")
    }

}