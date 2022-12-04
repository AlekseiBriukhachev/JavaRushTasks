package com.javarush.task.jdk13.task34.task3406;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

/* 
Классные методы
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        print(getMethods(Set.of(Object.class, Math.class, Arrays.class)));
    }

    public static Map<Class<?>, Set<String>> getMethods(Set<Class<?>> classes) {
        //напишите тут ваш код

//        return classes.stream()
//                .map(Class::getClass)
//                .map(aClass -> aClass.getMethods().toString())
//                .filter(method -> Modifier.isStatic(classes.getClass().getDeclaringClass().getModifiers()))
//                .collect(Collectors.toMap(Object::getClass, Collectors.toSet().getClass().));
        Map<Class<?>, Set<String>> map = new HashMap<>();
        for (Class<?> clazz : classes) {
            Set<String> set = new HashSet<>();
            map.put(clazz, set);
            for (Method method : clazz.getDeclaredMethods()){
                if (Modifier.isStatic(method.getModifiers())){
                    set.add(method.getName());
                }
            }
        }
        return map;
    }

    public static void print(Map<?, ?> map) {
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
