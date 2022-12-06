package com.javarush.task.pro.task05.task0506;

import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        //Ввести с клавиатуры число N.
        int N = scanner.nextInt();
        array = new int[N];
        //Считать N целых чисел и заполнить ими массив.
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        //Найти минимальное число среди элементов массива и вывести в консоль.
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        System.out.println(min);
    }
}
