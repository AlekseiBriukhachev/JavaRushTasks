package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(83, 0, 27);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
        //System.out.println(birthDate);
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        return new SimpleDateFormat("EEEEEEEEEEEE", new Locale("ru", "RU")).format(date);
    }
}
