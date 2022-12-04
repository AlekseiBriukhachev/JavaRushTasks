package com.javarush.task.jdk13.task23.task2301;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static void main(String[] args) {

    }

    public static Solution[] getTwoSolutions() {
        Solution solution = new Solution();
        solution.innerClasses[0] = new InnerClass();
        solution.innerClasses[1] = new InnerClass();

        Solution solution1 = new Solution();
        solution1.innerClasses[0] = new InnerClass();
        solution1.innerClasses[1] = new InnerClass();

        Solution[] result = new Solution[2];
        result[0] = solution;
        result[1] = solution1;
        return result;
    }

    public static class InnerClass {
    }
}
