package com.javarush.task.pro.task13.task1330;

public enum MySingleton {
    INSTANCE;
    private MySingleton(){
        System.out.println("создание экземпляра...");
    }
}
