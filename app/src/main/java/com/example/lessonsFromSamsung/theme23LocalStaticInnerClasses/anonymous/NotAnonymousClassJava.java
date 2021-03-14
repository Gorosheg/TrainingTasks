package com.example.lessonsFromSamsung.theme23LocalStaticInnerClasses.anonymous;

import android.view.View;

class NotAnonymousClassJava {

    View.OnClickListener listener = new Class();

    void foo() {
        View view = null;

        // Вызываем реализацию нашего метода onClick у OnClickListener
        listener.onClick(view);
    }

}

class Class implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        // You code here
    }

}