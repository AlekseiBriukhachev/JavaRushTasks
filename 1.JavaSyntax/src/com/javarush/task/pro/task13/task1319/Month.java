package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    //напишите тут ваш код
    public static Month[] getWinterMonths(){
        Month[] winterMonth = {DECEMBER, JANUARY, FEBRUARY};
        return winterMonth;
    }
    public static Month[] getSpringMonths(){
        Month[] springMonth = {MARCH, APRIL, MAY};
        return springMonth;
    }
    public static Month[] getSummerMonths(){
        Month[] summerMonth = {JUNE, JULY, AUGUST};
        return summerMonth;
    }
    public static Month[] getAutumnMonths(){
        Month[] autumnMonth = {SEPTEMBER, OCTOBER, NOVEMBER};
        return autumnMonth;
    }

}
