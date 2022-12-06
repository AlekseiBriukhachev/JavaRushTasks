package com.javarush.task.pro.task04.task0409;

import java.util.Scanner;

/* 
Минимум из введенных чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        int readNumber;
        int minNumber = 2147483647;
        while (console.hasNextInt()){
            readNumber = console.nextInt();
            if (readNumber < minNumber) minNumber = readNumber;
        }
        System.out.println(minNumber);
    }
}