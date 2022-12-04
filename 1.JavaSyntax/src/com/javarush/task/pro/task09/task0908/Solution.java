package com.javarush.task.pro.task09.task0908;

import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        //напишите тут ваш код
        String hexNumber = "";
        int decimalNumber = 0;
        String[] tetraBinaryNumber;
        //Если входящий параметр — пустая строка или null, то возвращает пустую строку
        if (binaryNumber == null || binaryNumber.equals("")) {
            return "";
        }
        //Если входящий параметр метода toHex(String) содержит любой символ,
        // кроме 0 или 1, то метод возвращает пустую строку.
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) != '0' & binaryNumber.charAt(i) != '1') {
                return "";
            }
        }
        if (binaryNumber.length() % 4 != 0) {
            do {
                binaryNumber = "0" + binaryNumber;
            } while (binaryNumber.length() % 4 != 0);
        }
        tetraBinaryNumber = getTetraOfBinaryNumber(binaryNumber);
        for (int i = 0; i < tetraBinaryNumber.length; i++) {
            for (int j = 0; j < tetraBinaryNumber[i].length(); j++) {
                decimalNumber = decimalNumber + Character.getNumericValue((tetraBinaryNumber[i].charAt(tetraBinaryNumber[i].length() - j - 1))) * ((int) (Math.pow(2, j)));
            }
            hexNumber = hexNumber + HEX.charAt(decimalNumber);
            decimalNumber = 0;
        }
        return hexNumber;
    }

    private static String[] getTetraOfBinaryNumber(String binaryNumber) {
        String[] tetraFromBinaryNumber = new String[binaryNumber.length() / 4];
        Arrays.fill(tetraFromBinaryNumber, "");
        int index = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            tetraFromBinaryNumber[index] = tetraFromBinaryNumber[index] + Character.getNumericValue((binaryNumber.charAt(i)));
            if (tetraFromBinaryNumber[index].length() % 4 == 0) {
                index++;
            }
        }
        return tetraFromBinaryNumber;
    }

    public static String toBinary(String hexNumber) {
        String binaryNumber = "";
        if (hexNumber == null) {
            return binaryNumber;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hexNumber.length(); i++) {
            String element;
            if(hexNumber.charAt(i) == '0') {
                element = "0000";
            } else if (hexNumber.charAt(i) == '1') {
                element = "0001";
            } else if (hexNumber.charAt(i) == '2') {
                element = "0010";
            } else if (hexNumber.charAt(i) == '3') {
                element = "0011";
            } else if (hexNumber.charAt(i) == '4') {
                element = "0100";
            } else if (hexNumber.charAt(i) == '5') {
                element = "0101";
            } else if (hexNumber.charAt(i) == '6') {
                element = "0110";
            } else if (hexNumber.charAt(i) == '7') {
                element = "0111";
            } else if (hexNumber.charAt(i) == '8') {
                element = "1000";
            } else if (hexNumber.charAt(i) == '9') {
                element = "1001";
            } else if (hexNumber.charAt(i) == 'a') {
                element = "1010";
            } else if (hexNumber.charAt(i) == 'b') {
                element = "1011";
            } else if (hexNumber.charAt(i) == 'c') {
                element = "1100";
            } else if (hexNumber.charAt(i) == 'd') {
                element = "1101";
            } else if (hexNumber.charAt(i) == 'e') {
                element = "1110";
            } else if (hexNumber.charAt(i) == 'f') {
                element = "1111";
            } else {
                result.setLength(0);
                break;
            }
            result.append(element);
        }
        return result.toString();
    }
}
