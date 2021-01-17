package com.aarya.heaps;

import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {
    private int capacity = 5;
    private int size = 0;
    private Object[] items;

    public MinHeap() {
        items = new Object[capacity];
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private Object leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private Object rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private Object parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int i0, int i1) {
        Object temp = items[i0];
        items[i0] = items[i1];
        items[i1] = temp;
    }

    private void shrinkArray() {
        if (size < capacity / 2) {
            items = Arrays.copyOf(items, capacity / 2);
        }
    }

    private void expandArray() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
        }
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        Object o = items[0];
        return (T) o;
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        Object item = items[0];
        items[0] = items[size - 1];
        size--;
        sink();
        shrinkArray();
        return (T) item;
    }

    public void add(int item) {
        items[size] = item;
        size++;
        swim();
        expandArray();
    }

    @SuppressWarnings("unchecked")
    public void swim() {
        int index = size - 1;
        while (hasParent(index) && ((T) parent(index)).compareTo((T) items[index]) > 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    @SuppressWarnings("unchecked")
    public void sink() {
        int index = 0;
        /*
         * note: we check for left child because there cannot be right child unless left
         * child exists
         */
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && ((T) rightChild(index)).compareTo((T) leftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (((T) items[index]).compareTo((T) items[smallerChildIndex]) < 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
