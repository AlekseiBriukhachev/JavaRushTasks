package com.javarush.task.jdk13.task06.task0623;

/* 
Знакомство с двумерным массивом
*/

import java.util.Scanner;

public class Solution {
    public static int[][] array;//напишите тут ваш код

    public static void main(String[] args) {
        //напишите тут ваш код
        array = new int[2][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                    array[i][j] = 1 + i + j;
                }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}
