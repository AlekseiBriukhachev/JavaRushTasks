package com.javarush.task.pro.task15.task1528;

import java.io.*;
import java.util.Scanner;

/* 
Пишем байты в файл
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             //Writer writer = new FileWriter(scanner.nextLine())) {
             FileOutputStream writer = new FileOutputStream(scanner.nextLine())){
            byte[] bytes = new byte[]{106, 97, 118, 97};
            writer.write(bytes);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}