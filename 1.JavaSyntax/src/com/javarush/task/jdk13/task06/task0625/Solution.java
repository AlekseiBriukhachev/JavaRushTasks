package com.javarush.task.jdk13.task06.task0625;

import java.util.Scanner;

/* 
Минимальная сумма
*/

public class Solution {
    public static int[][] array = new int[3][3];

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int min = 2147483647;
        for (int i = 0; i < array.length; i++) {
            int sum = array[0][i] + array[1][i] + array[2][i];
            if (min > sum) {
                min = sum;
            }
        }
        for (int i = 0; i < array[0].length; i++) {
            int sum = array[i][0] + array[i][1] + array[i][2];
            if (min > sum) {
                min = sum;
            }
        }
        System.out.println(min);
    }
}
