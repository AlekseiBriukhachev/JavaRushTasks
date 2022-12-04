package com.javarush.task.pro.task15.task1527;

import java.io.*;
import java.util.Scanner;

/* 
 Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        String fileName = console.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int i = 0;
            while(reader.ready()) {
                String line = reader.readLine();
                if (i % 2 == 0) {
                    System.out.println(line);
                }
                i++;
            }
        }
         catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}