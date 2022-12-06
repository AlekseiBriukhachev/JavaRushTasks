package com.javarush.task.pro.task03.task0312;

import java.util.Scanner;

/* 
Сравним строки
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        String string1 = console.nextLine();
        String string2 = console.nextLine();
        if (string1.equals(string2))
            System.out.println("строки одинаковые");
            //напишите тут ваш код
        else
            System.out.println("строки разные");
    }
}
