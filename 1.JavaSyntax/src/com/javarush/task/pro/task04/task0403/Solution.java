package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        int acc = 0;
        while (!console.hasNext("ENTER")){
            acc += console.nextInt();
        }
        System.out.println(acc);

    }
}