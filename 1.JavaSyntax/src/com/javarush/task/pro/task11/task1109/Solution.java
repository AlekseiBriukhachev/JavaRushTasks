package com.javarush.task.pro.task11.task1109;

/* 
Объекты внутренних и вложенных классов
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Outer.Inner innerClassObject = new Outer().new Inner();
        Outer.Nested nestedClassObject = new Outer.Nested();
    }
}
