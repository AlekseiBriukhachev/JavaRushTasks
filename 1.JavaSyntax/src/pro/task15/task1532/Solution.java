package com.javarush.task.pro.task15.task1532;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/* 
Шифр
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(encrypt("abcdefghi"));
    }

    public static ByteArrayOutputStream encrypt(String message) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        for (int i = 0; i < length / 2; i++) {
            stream.write(bytes[i]);
            stream.write(bytes[length - i - 1]);
        }
        if (length % 2 == 1) {
            stream.write(bytes[length / 2]);
        }

        return stream;
    }
}
