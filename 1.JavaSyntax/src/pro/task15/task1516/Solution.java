package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        String line;
        while (true) {
            line = console.nextLine();
            if (Files.isRegularFile(Path.of(line))){
                System.out.println(line + THIS_IS_FILE);
            }else if (Files.isDirectory(Path.of(line))){
                System.out.println(line + THIS_IS_DIR);
            }else {
                break;
            }
        }
    }
}

