package com.javarush.task.jdk13.task28.task2804;

public class MyThread extends Thread {
    private static int counter = Thread.MIN_PRIORITY;

    public MyThread() {
        if (counter > Thread.MAX_PRIORITY) {
            counter = Thread.MIN_PRIORITY;
        }
        setPriority(counter);
        counter++;
    }

    public MyThread(Runnable target) {
        super(target);
        if (counter > Thread.MAX_PRIORITY) {
            counter = Thread.MIN_PRIORITY;
        }
        setPriority(counter);
        counter++;
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (counter > Thread.MAX_PRIORITY) {
            counter = Thread.MIN_PRIORITY;
        }
        setPriority(counter);
        counter++;
    }

    public MyThread(String name) {
        super(name);
        if (counter > Thread.MAX_PRIORITY) {
            counter = Thread.MIN_PRIORITY;
        }
        setPriority(counter);
        counter++;
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (counter > Thread.MAX_PRIORITY) {
            counter = Thread.MIN_PRIORITY;
        }
        setPriority(counter);
        counter++;
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (counter > Thread.MAX_PRIORITY) {
            counter = Thread.MIN_PRIORITY;
        }
        setPriority(counter);
        counter++;
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (counter > Thread.MAX_PRIORITY) {
            counter = Thread.MIN_PRIORITY;
        }
        setPriority(counter);
        counter++;
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (counter > Thread.MAX_PRIORITY) {
            counter = Thread.MIN_PRIORITY;
        }
        setPriority(counter);
        counter++;
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
        super(group, target, name, stackSize, inheritThreadLocals);
        if (counter > Thread.MAX_PRIORITY) {
            counter = Thread.MIN_PRIORITY;
        }
        setPriority(counter);
        counter++;
    }
}
