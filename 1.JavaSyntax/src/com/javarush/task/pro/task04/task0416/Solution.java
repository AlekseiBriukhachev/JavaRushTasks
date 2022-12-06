package com.javarush.task.pro.task04.task0416;

import java.util.Scanner;

/* 
Share a Coke
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        int numOfCola = console.nextInt();
        int numOfProgrammers = console.nextInt();
        System.out.println(numOfCola * 1.0 / numOfProgrammers);

    }
}