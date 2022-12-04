package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int y = 0;
        while (y < 10) {
            int x = 0;
            while (x < 20) {
                if (y > 0 && y < 9 && x > 0 && x < 19)
                    System.out.print(" ");
                else
                    System.out.print("Б");
                x++;
            }
            y++;
            System.out.println();
        }

    }
}