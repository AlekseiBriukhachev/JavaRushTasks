package com.javarush.task.pro.task15.task1526;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        String fileName = console.nextLine();
        try (FileReader reader = new FileReader(fileName)) {
//            char[] buffer = new char[1024];
//            int c;
//            while (reader.ready()) {
//                c = reader.read(buffer);
//                buffer = Arrays.copyOf(buffer, c);
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < buffer.length; i++) {
//                sb.append(buffer[i]);
//            }
//            System.out.println(sb.toString().replaceAll("[^a-z^A-Z]", ""));
            while (reader.ready()) {
                char ch = (char) reader.read();
                if (ch != ' ' && ch != '.' && ch != ',') {
                    System.out.print(ch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}