package com.javarush.task.pro.task13.task1316;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        List<JavarushQuest> valuesList = new ArrayList<>();
        Collections.addAll(valuesList, JavarushQuest.values());
        valuesList.forEach(javarushQuest -> System.out.println(javarushQuest.ordinal()));
    }
}
