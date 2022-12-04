package com.javarush.task.pro.task03.task0305;

import java.util.Scanner;

/* 
Три числа
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        int firstNumber = console.nextInt();
        int secondNumber = console.nextInt();
        int thirdNumber = console.nextInt();
        if (firstNumber == secondNumber && secondNumber == thirdNumber && firstNumber == thirdNumber)
            System.out.println(firstNumber + " " + secondNumber + " " + thirdNumber);
        else if (firstNumber == secondNumber) System.out.println(firstNumber + " " + secondNumber);
        else if (secondNumber == thirdNumber) System.out.println(secondNumber + " " + thirdNumber);
        else if (firstNumber == thirdNumber) System.out.println(firstNumber + " " + thirdNumber);

    }
}
