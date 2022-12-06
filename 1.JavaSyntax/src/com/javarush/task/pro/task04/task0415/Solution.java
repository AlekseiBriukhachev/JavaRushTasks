package com.javarush.task.pro.task04.task0415;

import java.util.Scanner;

/* 
Площадь круга
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        int radius = console.nextInt();
        int s = (int) Math.floor(3.14 * radius * radius);
        System.out.println(s);

    }
}