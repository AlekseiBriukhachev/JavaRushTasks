package com.javarush.task.pro.task06.task0605;

/* 
Правильный порядок
*/

import static java.lang.System.arraycopy;

public class Solution {

    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        printArray(array);
        reverseArray(array);
        printArray(array);
    }

    public static void reverseArray(int[] array) {
        //напишите тут ваш код
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[i];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = reversedArray[array.length - i - 1];
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
