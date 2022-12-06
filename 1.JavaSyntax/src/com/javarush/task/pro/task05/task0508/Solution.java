package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        strings = new String[6];
        //Считать 6 строк и заполнить ими массив strings.
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();
        }
        //Удалить повторяющиеся строки из массива strings,
        // заменив их на null (null должны быть не строками "null").
        String tempStr = "";
        for (int i = 0; i < strings.length; i++) {
            tempStr = strings[i];
            for (int j = i + 1; j < strings.length; j++) {
                if (tempStr == null) {
                    break;
                }
                if (tempStr.equals(strings[j])){
                    strings[i] = null;
                    strings[j] = null;
                }
            }
        }
        for (String string : strings) {
            System.out.print(string + ", ");
        }
    }
}
