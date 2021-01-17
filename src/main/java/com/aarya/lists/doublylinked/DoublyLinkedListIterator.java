package com.aarya.lists.doublylinked;

import java.util.Iterator;

public class DoublyLinkedListIterator<T extends Comparable<T>> implements Iterator<T> {

    DoublySortedLinkedList<T> myList;
    DoublyLinkedListNode<T> currentNode;

    public DoublyLinkedListIterator(DoublySortedLinkedList<T> list) {
        this.myList = list;
        this.currentNode = list.getHeadNode();
    }

    public void reset() {
        this.currentNode = this.myList.getHeadNode();
    }

    @Override
    public boolean hasNext() {
        return !this.myList.isTailNode(currentNode.getNext());
    }

    @Override
    public T next() {
        this.currentNode = this.currentNode.getNext();

        if (this.myList.isTailNode(currentNode)) {
            throw new NullPointerException();
        }

        return this.currentNode.getData();
    }

}