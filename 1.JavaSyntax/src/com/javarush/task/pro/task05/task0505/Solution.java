package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        //Считывает с консоли целое число N.
        int N = scanner.nextInt();
        int[] numberArray = new int[N];
        //Если считанное число N больше 0, то программа дальше считывает целые числа,
        // количество которых равно N.
        if (N > 0) {
            for (int i = 0; i < numberArray.length; i++) {
                numberArray[i] = scanner.nextInt();
            }
        }
        //Вывести в консоль считанные числа, если N нечетное — в порядке ввода, иначе — в обратном порядке.
        if (N % 2 != 0){
            for (int i = 0; i < numberArray.length; i++) {
                System.out.println(numberArray[i]);
            }
        }
        else {
            for (int i = numberArray.length - 1; i >= 0; i--) {
                System.out.println(numberArray[i]);
            }
        }
    }
}
