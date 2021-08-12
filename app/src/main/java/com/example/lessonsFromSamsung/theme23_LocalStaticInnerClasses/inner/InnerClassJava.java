package com.example.lessonsFromSamsung.theme23_LocalStaticInnerClasses.inner;

class InnerMain {

    void main() {
        InnerClassJava innerClass = new InnerClassJava();
        InnerClassJava.Inner inner = innerClass.new Inner();
    }

}

class InnerClassJava {

    private int someValue = 0;

    private void bar() {
        someValue = 2;
    }

    class Inner {

        void foo() {
            someValue = 1;
        }

    }

}
