package com.javarush.task.jdk13.task38.task3801;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface LongPositive {

}
