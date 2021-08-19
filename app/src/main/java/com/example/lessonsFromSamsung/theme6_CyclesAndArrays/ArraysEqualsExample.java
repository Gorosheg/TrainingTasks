package com.example.lessonsFromSamsung.theme6_CyclesAndArrays;

import java.util.Arrays;

public class ArraysEqualsExample {
    /**
     * Сравнение строк по ссылке и значению
     * Сравнение массивов
     */

    public static void main(String[] args) {
        String qwe1 = "";
        String qwe2 = "";

        Boolean result1 = qwe1 == qwe2; // qwe1 === qwe2 // Сравнение по ссылке
        Boolean result2 = qwe1.equals(qwe2); // qwe1 == qwe2 // Сравнение по значению

        int[] a = {1, 2};
        int[] b = a.clone();
        Boolean result3 = a == b; // Сравнение по ссылке
        Boolean result4 = a.equals(b); // Так нельзя: 'equals()' between arrays should probably be 'Arrays.equals()'
        Boolean result5 = Arrays.equals(a, b); // Сравниваем по значению
    }
}

