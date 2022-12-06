package com.javarush.task.jdk13.task38.task3804;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface Entity {
    String name();
    int value() default 45;
    boolean required() default true;
}
