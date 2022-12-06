package com.javarush.task.pro.task13.task1326;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyQueue extends AbstractQueue<String> {

    private final List<String> values = new ArrayList<>();

    @Override
    public Iterator<String> iterator() {
        //напишите тут ваш код
        Iterator<String> it = values.iterator();
        return it;
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return values.size();
    }

    @Override
    public boolean offer(String o) {
        //напишите тут ваш код
        return values.add(o);
    }

    @Override
    public String poll() {
        String o = null;
        //напишите тут ваш код
        if (!values.isEmpty()){
            o = values.get(0);
            values.remove(0);
        }
        return o;
    }

    @Override
    public String peek() {
        //напишите тут ваш код
        String o;
        return o = (!values.isEmpty()) ? values.get(0) : null;
    }
}
