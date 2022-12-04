package com.javarush.task.jdk13.task20.task2011;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;

/* 
Создание класса по строке yaml
*/

public class Solution {
    public static void main(String[] args) throws JsonProcessingException {
        String yamlData =
                "---\n" +
                        "goods:\n" +
                        "  names:\n" +
                        "  - \"S1\"\n" +
                        "  - \"S2\"\n" +
                        "count: 12\n" +
                        "profit: 123.4\n" +
                        "secretData:\n" +
                        "- \"String1\"\n" +
                        "- \"String2\"\n" +
                        "- \"String3\"\n" +
                        "- \"String4\"\n" +
                        "- \"String5\"";

        ObjectMapper mapper = new YAMLMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(yamlData, Shop.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(shop);
    }
}
