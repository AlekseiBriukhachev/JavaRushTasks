package com.javarush.task.jdk13.task34.task3405;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/*
Нарушение приватности
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        User user = new User("Amigo", 21);
        print(getFields(user));

        Task task = new Task("task3405", true);
        print(getFields(task));
    }

    public static Map<String, Object> getFields(Object object) throws Exception {
        //напишите тут ваш код
        Map<String, Object> map = new HashMap<>();
//        Field[] fields = object.getClass().getDeclaredFields();
//        int modifier = object.getClass().getModifiers();
//        if (Modifier.isPrivate(modifiers)){
//            fields = ;
//        }

//        return Arrays.stream(fields)
//                .filter(field -> !Modifier.isPrivate(modifier))
//                .map(Field::setAccessible)
//                .collect(Collectors.toMap(Field::getName, field -> {
//                    try {
//                        return field.get(object);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }));
        for (Field field : object.getClass().getDeclaredFields()) {
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(object));
            }
        }
        return map;
    }

    public static void print(Map<?, ?> fields) {
        System.out.println("-------------------");
        fields.forEach((fieldName, fieldValue) -> System.out.println(fieldName + " = " + fieldValue));
    }
}
