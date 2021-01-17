package com.aarya.lists;


public class LinkedDeque<T> extends DoublyLinkedListBase<T> implements LinkedDequeMap<T> {
	
	public LinkedDeque() {
		super();
	}

	@Override
	public T first() {
		if(isEmpty()) {
			return null;
		}
		return header.next.key;
	}

	@Override
	public T last() {
		if(isEmpty()) {
			return null;
		}
		return trailer.prev.key;
	}

	@Override
	public void insertFirst(T element) {
		insertBetween(element, header, header.next);
	}

	@Override
	public void insertLast(T element) {
		insertBetween(element, trailer.prev, trailer);
	}

	@Override
	public T deleteFirst() {
		if(isEmpty()) return null;
		return deleteNode(header.next);
	}

	@Override
	public T deleteLast() {
		if(isEmpty()) return null;
		return deleteNode(trailer.prev);
	}

	
}
