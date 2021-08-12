package com.example.lessonsFromSamsung.theme23_LocalStaticInnerClasses.anonymous

import android.view.View
import android.view.View.OnAttachStateChangeListener

private class AnonymousClassKotlin {

    val onAttachListener: OnAttachStateChangeListener = object : OnAttachStateChangeListener {

        override fun onViewAttachedToWindow(v: View) {
            // You code here
        }

        override fun onViewDetachedFromWindow(v: View) {
            // You code here
        }

    }

    val listener: View.OnClickListener = object : View.OnClickListener {

        override fun onClick(v: View?) {
            // You code here
        }

    }

    val listenerWithLambda: View.OnClickListener = View.OnClickListener {
        // You code here
    }

    // Lambda - это функция.
    // В скобках мы передаём параметры для этой функции,
    // а через стрелочку - возвращаемй тип
    val lambda: (View?) -> Unit = {
        // You code here
    }

    val lambdaMultyParams: (string: String, Int, Boolean) -> Unit = { string, int, _ ->
        // You code here
    }

    fun foo() {
        val view: View? = null

        // Вызываем реализацию нашего метода onClick у OnClickListener
        listener.onClick(view)
        listenerWithLambda.onClick(view)
        lambda.invoke(view) // тут invoke = onClick
        lambdaMultyParams.invoke("", 1, true)

        // Можешь передать лисенер вьюхе, чтоб она его вызвала
        view?.setOnClickListener(listener)
        view?.setOnClickListener(listenerWithLambda)
        view?.setOnClickListener(lambda)

        view?.setOnClickListener {
            // You code here
        }
    }

}