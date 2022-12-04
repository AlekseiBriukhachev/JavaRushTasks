package com.javarush.task.jdk13.task28.task2811;

/*
Знакомство с Executors
*/


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //напишите тут ваш код
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 20; i++) {
            final int finalI = i;
            executorService.submit(() -> doExpensiveOperation(finalI));
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

    }

    private static void doExpensiveOperation(int localID) {
        System.out.println(Thread.currentThread().getName() + ", localID=" + localID);
    }
}