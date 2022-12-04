package com.javarush.task.pro.task18.task1816;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CodeWars {
    @Test
    public void sampleTests() {
        assertArrayEquals(new int[] {2}, Kata.arrayDiff(new int [] {1,2}, new int[] {1}));
        assertArrayEquals(new int[] {2,2}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {1}));
        assertArrayEquals(new int[] {1}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {2}));
        assertArrayEquals(new int[] {1,2,2}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {}));
        assertArrayEquals(new int[] {}, Kata.arrayDiff(new int [] {}, new int[] {1,2}));
    }
    public class Kata {

        public static int[] arrayDiff(int[] a, int[] b) {
            // Your code here
            List<Integer> list = new ArrayList<>();
            for (int ela : a){
                for (int elb : b){
                    if (ela != elb)
                        list.add(elb);
                }
            }
            int[] c = new int[list.size()];

            return c;
        }

    }

}

