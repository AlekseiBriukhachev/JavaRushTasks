package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public StringsLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public void add(String value) {
        //напишите тут ваш код
        //должен создавать новый объект класса Node,
        // в который он поместит переданное значение.
        Node node = new Node();
        //Перед тем как добавлять новую ноду, нужно изменить ссылку последней ноды
        // на новосозданную, а новосозданная станет последней.
        //1. При добавлении нового элемента предыдущие элементы должны получать на него ссылку.
        //2. При добавлении нового элемента он должен получать ссылку на предыдущий.
        node.value = value;
        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;

    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
