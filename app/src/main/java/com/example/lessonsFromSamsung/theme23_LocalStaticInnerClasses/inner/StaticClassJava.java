package com.example.lessonsFromSamsung.theme23_LocalStaticInnerClasses.inner;

class StaticMain {

    void main() {
        StaticClassJava staticClass = new StaticClassJava();
        StaticClassJava.Static staticC = new StaticClassJava.Static();
    }

}

class StaticClassJava {

    private static int someValue = 0;
    private int notStaticValue = 0;

    private void bar() {
        someValue = 2;
        notStaticValue = 2;
    }

    static class Static {

        void foo() {
            someValue = 1;
            // We can't use notStaticValue
        }

    }

}
