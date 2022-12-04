package com.javarush.task.pro.task04.task0408;

import java.util.Scanner;

/* 
Максимум из введенных чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        int readNumber;
        int maxNumber = -2147483648;
        while (console.hasNextInt()){
            readNumber = console.nextInt();
            if (readNumber % 2 == 0){
                if (readNumber > maxNumber) maxNumber = readNumber;
            }
        }
        System.out.println(maxNumber);
    }
}