package com.aarya.lists.doublylinked;


public class Main {
    public static void main(String[] args) {
        DoublySortedLinkedList<Float> l = new DoublySortedLinkedList<>();

        for (int i = 0; i < 10; i++) {
            float num = (float) (Math.random() * 100);
            l.add(num);
        }

        System.out.println(l.toString());
    }
}
