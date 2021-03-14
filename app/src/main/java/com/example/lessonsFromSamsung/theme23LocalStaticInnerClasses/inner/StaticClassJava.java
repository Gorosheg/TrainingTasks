package com.example.lessonsFromSamsung.theme23LocalStaticInnerClasses.inner;

class StaticMain {

    void main() {
        StaticClassJava staticClass = new StaticClassJava();
        StaticClassJava.Static staticC = new StaticClassJava.Static();
    }

}

class StaticClassJava {

    private int someValue = 0;

    private void bar() {
        someValue = 2;
    }

    static class Static {

        void foo() {
            // We can't use someValue
        }

    }

}
