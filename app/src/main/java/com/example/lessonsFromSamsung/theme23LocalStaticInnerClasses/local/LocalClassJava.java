package com.example.lessonsFromSamsung.theme23LocalStaticInnerClasses.local;

class LocalClassJava {

    void bar() {
        int someValue = 0;

        class Local {

            void foo() {
                // Why need array??
                // someValue = 1;
            }

        }

        Local local = new Local();

    }

}

