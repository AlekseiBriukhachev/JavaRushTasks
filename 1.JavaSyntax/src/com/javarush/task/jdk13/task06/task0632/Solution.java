package com.javarush.task.jdk13.task06.task0632;


import java.io.IOException;
import java.util.Scanner;

/* 
Пирамида
*/

public class Solution {
    public static char[][] array;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        //считать число с клавиатуры — это и будет высота пирамиды
        int height = scanner.nextInt();
        //инициализировать массив array соответствующим значением
        array = new char[height][height * 2 - 1];
        //заполнить массив так, чтобы получилась пирамида
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j < array.length - i -1 || j > array[i].length - array.length + i){
                    array[i][j] = ' ';
                }else {
                    array[i][j] = '#';
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }
}
