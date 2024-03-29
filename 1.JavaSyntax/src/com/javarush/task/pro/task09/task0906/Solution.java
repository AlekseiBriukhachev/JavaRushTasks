package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        //напишите тут ваш код
        String binaryNumber = "";
        if (decimalNumber <= 0) {
            return binaryNumber;
        }
        while (decimalNumber != 0) {
            binaryNumber = decimalNumber % 2 + binaryNumber;
            decimalNumber /= 2;
        }
        return binaryNumber;
    }

    public static int toDecimal(String binaryNumber) {
        //напишите тут ваш код
        int decimalNumber = 0;
        if (binaryNumber == null) {
            return decimalNumber;
        }
            for (int i = 0; i < binaryNumber.length(); i++) {
                int index = binaryNumber.length() - 1 - i;
                int binaryTemp = Character.getNumericValue(binaryNumber.charAt(index));
                decimalNumber += binaryTemp * Math.pow(2, i);
            }
        return decimalNumber;
    }
}
