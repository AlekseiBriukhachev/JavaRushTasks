package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Aleksei", 5.5);
        grades.put("Jan", 4.2);
        grades.put("Fedor", 3.6);
        grades.put("Viktor", 4.8);
        grades.put("Dodo", 8.9);
    }
}
