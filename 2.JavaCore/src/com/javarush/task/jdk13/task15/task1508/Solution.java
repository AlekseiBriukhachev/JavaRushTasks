package com.javarush.task.jdk13.task15.task1508;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();
    static {
        labels.put(5d, "");
        labels.put(10d, "q");
        labels.put(1555d, "p");
        labels.put(87d, "ld");
        labels.put(98d, "lp");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
