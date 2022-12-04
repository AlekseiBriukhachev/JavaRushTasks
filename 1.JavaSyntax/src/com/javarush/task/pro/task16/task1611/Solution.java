package com.javarush.task.pro.task16.task1611;

import java.time.LocalTime;

/* 
Нужно просто посчитать
*/

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        LocalTime localTime = LocalTime.MIDNIGHT;
        LocalTime next = amazingMethod(localTime);
        while (next.isAfter(localTime)) {
            System.out.println(next);
            next = amazingMethod(next);
            Thread.sleep(500);
        }
    }

    static LocalTime amazingMethod(LocalTime base) {
        //24/5 = 4,8
        //4,8*60 = 288
        //Цикл отработает 4 раза,
        // на 5й раз время будет равно Midnite поэтому цикл уже не отработает.
        return base.plusMinutes(288);
    }
}
