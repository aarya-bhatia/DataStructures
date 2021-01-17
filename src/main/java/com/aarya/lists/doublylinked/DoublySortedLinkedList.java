package com.aarya.lists.doublylinked;


import java.util.Comparator;
import java.util.Iterator;

public class DoublySortedLinkedList<T extends Comparable<T>> implements Iterable<T> {

    public final Comparator<DoublyLinkedListNode<T>> myComparator = new DoublyLinkedListComparator<>();

    DoublyLinkedListNode<T> headGuardNode;

    DoublyLinkedListNode<T> tailGuardNode;

    public DoublySortedLinkedList() {
        headGuardNode = new DoublyLinkedListNode<>(null);
        tailGuardNode = new DoublyLinkedListNode<>(null);

        headGuardNode.setNext(tailGuardNode);
        tailGuardNode.setPrev(headGuardNode);

    }

    public boolean isTailNode(DoublyLinkedListNode<T> node) {
        return node == this.tailGuardNode;
    }

    public DoublyLinkedListNode<T> getHeadNode() {
        return this.headGuardNode;
    }

    public void add(T data) {
        DoublyLinkedListNode<T> nodeToAdd = new DoublyLinkedListNode<>(data);

        DoublyLinkedListNode<T> currentNode = headGuardNode.getNext();

        while (true) {

            if (currentNode == tailGuardNode || myComparator.compare(currentNode, nodeToAdd) > 0) {
                // Adding new node between the current node and the previous node
                DoublyLinkedListNode<T> previousNode = currentNode.getPrev();

                previousNode.setNext(nodeToAdd);
                nodeToAdd.setPrev(previousNode);

                currentNode.setPrev(nodeToAdd);
                nodeToAdd.setNext(currentNode);

                break;
            }

            currentNode = currentNode.getNext();
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder("[");

        for (T data : this) {
            s.append(data.toString());
            s.append(", ");
        }

        s.deleteCharAt(s.length() - 1);
        s.append("]");

        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator<>(this);
    }

}
