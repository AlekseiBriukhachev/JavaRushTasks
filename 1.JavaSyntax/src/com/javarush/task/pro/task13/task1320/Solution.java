package com.javarush.task.pro.task13.task1320;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMonthByIndex(4));
        System.out.println(getMonthByIndex(8));
        System.out.println(getMonthByIndex(12));
    }

    public static String getMonthByIndex(int monthIndex) {
        String monthString;
        switch (monthIndex) {
            case 1 -> monthString = "Январь";
            case 2 -> monthString = "Февраль";
            case 3 -> monthString = "Март";
            case 4 -> monthString = "Апрель";
            case 5 -> monthString = "Май";
            case 6 -> monthString = "Июнь";
            case 7 -> monthString = "Июль";
            case 8 -> monthString = "Август";
            case 9 -> monthString = "Сентябрь";
            case 10 -> monthString = "Октябрь";
            case 11 -> monthString = "Ноябрь";
            case 12 -> monthString = "Декабрь";
            default -> monthString = "Недействительный месяц";
        }
        return monthString;
    }
}
