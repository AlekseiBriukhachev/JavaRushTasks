package com.javarush.task.pro.task15.task1524;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
       try(Scanner scanner = new Scanner(System.in);
           FileInputStream fis = new FileInputStream(scanner.nextLine());
           FileOutputStream fos = new FileOutputStream(scanner.nextLine())){
           byte[] bytesIn = fis.readAllBytes();
           byte[] bytesOut = new byte[bytesIn.length];
           for (int i = 0; i < bytesIn.length; i += 2) {
               if (i < bytesIn.length - 1){
                   bytesOut[i] = bytesIn[i + 1];
                   bytesOut[i + 1] = bytesIn[i];
               }else{
                   bytesOut[i] = bytesIn[i];
               }
           }
           fos.write(bytesOut);
       }catch (IOException e){
           e.printStackTrace();
       }
    }
}