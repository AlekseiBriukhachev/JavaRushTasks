package com.javarush.task.jdk13.task06.task0627;

import java.util.Scanner;

/* 
Вот это переворот!
*/

public class Solution {
    public static int[][] array = new int[3][3];

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        //построчно заполнить этот массив числами с клавиатуры;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        //перевернуть массив относительно главной диагонали
        int[][] rotatedArray = new int[3][3];
        for (int i = 0; i < rotatedArray.length; i++) {
            for (int j = 0; j < rotatedArray[i].length; j++) {
                rotatedArray[j][i] = array[i][j];
            }
        }
        array = rotatedArray;
        //вывести перевернутый массив на экран
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
