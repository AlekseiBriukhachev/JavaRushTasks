package com.javarush.task.jdk13.task13.task1304;

/* 
Эй, ты там живой?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

    }
    interface Person{
        boolean isAlive = false;
        static boolean isAlive(){
            return isAlive;
        }
    }
    interface Presentable extends Person {

    }
}