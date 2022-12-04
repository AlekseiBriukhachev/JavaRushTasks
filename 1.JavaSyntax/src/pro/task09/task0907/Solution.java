package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        //напишите тут ваш код
        String hexNumber = "";
        if (decimalNumber <= 0) {
            return "";
        }
        while (decimalNumber != 0) {
            int index = decimalNumber % 16;
            hexNumber = HEX.charAt(index) + hexNumber;
            decimalNumber /= 16;
        }
        return hexNumber;
}

    public static int toDecimal(String hexNumber) {
        //напишите тут ваш код
        int decimalNumber = 0;
        if (hexNumber == null || hexNumber.equals("")){
            return 0;
        }
        for (int i = 0; i < hexNumber.length(); i++) {
            decimalNumber = 16 * decimalNumber + HEX.indexOf(hexNumber.charAt(i));
        }
        return decimalNumber;
    }
}
