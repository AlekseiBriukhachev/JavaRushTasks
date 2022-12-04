package com.javarush.task.pro.task13.task1324;

import java.util.Random;
import java.util.TreeMap;

/* 
Зарплаты и позиции
*/

public class Solution {

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(0, "Newbie");
        map.put(200, "Trainee");
        map.put(800, "Junior");
        map.put(1200, "Strong Junior");
        map.put(2700, "Middle");
        map.put(3500, "Strong Middle");
        map.put(5000, "Senior");

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int salary = random.nextInt(50) * 100;
            String position = getJobTitle(map, salary);
            System.out.printf("Зарплате $%d соответствует позиция %s%n", salary, position);
        }
    }

    public static String getJobTitle(TreeMap<Integer, String> map, Integer salary) {
        //напишите тут ваш код
        return map.get(map.floorKey(salary));
    }
}