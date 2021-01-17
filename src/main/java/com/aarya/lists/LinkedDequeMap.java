package com.aarya.lists;

public interface LinkedDequeMap<T> {
	
	// return the first element of the queue
	public T first();
	
	// return the last element of the queue
	public T last();
	
	// add an element to the front
	public void insertFirst(T element);
	
	// add an element to the rear
	public void insertLast(T element);
	
	// remove and return the element from front
	public T deleteFirst();
	
	// remove and return the element from rear
	public T deleteLast();
	
}