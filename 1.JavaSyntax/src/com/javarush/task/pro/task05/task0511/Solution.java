package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        //напишите тут ваш код
        //Считывает из консоли число N — количество строк массива
        // (считай, что это число будет больше 0, можно не проверять).
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        //Считывает N чисел из консоли (любые числа, которые будут больше 0,
        //можно не проверять).
        multiArray = new int[N][];
        for (int i = 0; i < N; i++) {
            multiArray[i] = new int[scanner.nextInt()];
        }
    }
}
