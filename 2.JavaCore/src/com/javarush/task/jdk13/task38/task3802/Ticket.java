package com.javarush.task.jdk13.task38.task3802;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Ticket {
    enum Priority{
        LOW, MEDIUM, HIGH
    }
    Priority priority() default Priority.MEDIUM;
    String createdBy() default "Amigo";
    String[] tags() default {};
}
