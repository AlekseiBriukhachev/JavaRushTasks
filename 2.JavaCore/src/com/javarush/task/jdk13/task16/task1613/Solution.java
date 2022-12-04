package com.javarush.task.jdk13.task16.task1613;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //напишите тут ваш код
        SpecialThread sp1 = new SpecialThread();
        SpecialThread sp2 = new SpecialThread();
        SpecialThread sp3 = new SpecialThread();
        SpecialThread sp4 = new SpecialThread();
        SpecialThread sp5 = new SpecialThread();
        Thread tread1 = new Thread(sp1);
        Thread tread2 = new Thread(sp2);
        Thread tread3 = new Thread(sp3);
        Thread tread4 = new Thread(sp4);
        Thread tread5 = new Thread(sp5);
        Collections.addAll(list, tread1, tread2, tread3, tread4, tread5);
        list.forEach(Thread::run);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
