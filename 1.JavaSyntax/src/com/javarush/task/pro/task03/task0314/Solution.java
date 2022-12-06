package com.javarush.task.pro.task03.task0314;

import java.util.Scanner;

/* 
Сломанная клавиатура
*/

public class Solution {
    public static String secret = "AmIGo";

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        if (secret.equalsIgnoreCase(console.nextLine()))
            System.out.println("доступ разрешен");
            //напишите тут ваш код
        else
            System.out.println("доступ запрещен");
    }
}
