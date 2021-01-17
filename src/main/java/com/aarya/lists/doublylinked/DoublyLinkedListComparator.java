package com.aarya.lists.doublylinked;

import java.util.Comparator;

public class DoublyLinkedListComparator<T extends Comparable<T>> implements Comparator<DoublyLinkedListNode<T>> {

    @Override
    public int compare(DoublyLinkedListNode<T> o1, DoublyLinkedListNode<T> o2) {
        return o1.getData().compareTo(o2.getData());
    }

}