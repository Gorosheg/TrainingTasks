package com.example.lessonsFromSamsung.theme23_LocalStaticInnerClasses.anonymous;

import android.view.View;

class AnonymousClassJava {

    View.OnAttachStateChangeListener onAttachListener = new View.OnAttachStateChangeListener() {

        @Override
        public void onViewAttachedToWindow(View v) {
            // You code here
        }

        @Override
        public void onViewDetachedFromWindow(View v) {
            // You code here
        }

    };

    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // You code here
        }

    };

    View.OnClickListener listenerWithLambda = v -> {
        // You code here
    };

    void foo() {
        View view = null;

        // Вызываем реализацию нашего метода onClick у OnClickListener
        listener.onClick(view);
    }

}