package com.aarya.lists;

import java.util.Iterator;

class PositionalListIterator<T> implements Iterator<T> {
	PositionalList<T> list;
	PositionalList.Position<T> current;
	
	public PositionalListIterator(PositionalList<T> L) {
		list = L;
		current = L.first();
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		T data = current.key();
		current = list.after(current);
		return data;
	}
	
}


/* A sequential container of elements allowing positional access */
public class PositionalList<T> extends DoublyLinkedListBase<T> implements Iterable<T> {
	
	public PositionalList() {
		super();
	}
	
	/* Represents the location of a single element */
	static class Position<T> {
		PositionalList<T> container;
		Node<T> node;
		
		public Position(PositionalList<T> c, Node<T> n) {
			container = c;
			node = n;
		}
		
		public T key() {
			return node.key;
		}
		
		public boolean equals(Position<T> other) {
			return node == other.node;
		}
	}
	
	/** Utility Methods */
	
	/* return the position's node or throw an error */
	private Node<T> validate(Position<T> p) {

		if(p.container != this) {
			throw new IllegalArgumentException("p does not belong to this container");
		}
		
		if(p.node.next == null) {
			throw new IllegalArgumentException("p is no longer valid");
		}
		
		return p.node;
	}
	
	/* return a position instance for given node */
	private Position<T> makePosition(Node<T> node) {
		// boundary violation
		if(node == header || node == trailer) {
			return null;
		}
		// valid position
		return new Position<T>(this, node); 
	}
	
	/** Access Methods */
	
	/* Return the first position in the list */
	public Position<T> first() {
		return makePosition(header.next);
	}
	
	/* Return the last position in the list */
	public Position<T> last() {
		return makePosition(trailer.prev);
	}
	
	/* Return the position just after position p */
	public Position<T> after(Position<T> p) {
		Node<T> node = validate(p);
		return makePosition(node.next);
	}
	
	/* Return the position just before position p */
	public Position<T> before(Position<T> p) {
		Node<T> node = validate(p);
		return makePosition(node.prev);
	}

	@Override
	public Iterator<T> iterator() {
		return new PositionalListIterator<T>(this);
	}
	
	/** MUTATORS */
	/** override inherited methods to return Position rather than Node instance */
	
	/* Add element between existing nodes and return new Position */
	private Position<T> _insertBetween(T element, Node<T> nodeBefore, Node<T> nodeAfter){
		Node<T> node = super.insertBetween(element, nodeBefore, nodeAfter);
		Position<T> p = makePosition(node);
		return p;
	}
	
	/* Add element at the front of the list and return new Position */
	public Position<T> addFirst(T element){
		return _insertBetween(element, header, header.next);
	}
	
	/* Add element at the back of the list and return new Position */
	public Position<T> addLast(T element){
		return _insertBetween(element, trailer.prev, trailer);
	}
	
	/* Add element before Position p and return new Position */
	public Position<T> addBefore(Position<T> p, T element){
		Node<T> node = validate(p);
		return _insertBetween(element, node.prev, node);
	}
	
	/* Add element after Position p and return new Position */
	public Position<T> addAfter(Position<T> p, T element){
		Node<T> node = validate(p);
		return _insertBetween(element, node, node.next);
	}
	
	/* Remove and return element at Position p */
	public T delete(Position<T> p) {
		Node<T> node = validate(p);
		return deleteNode(node);
	}
	
	/* Replace the element at position p with e and return old value */
	public T replace(Position<T> p, T e) {
		Node<T> node = validate(p);
		T oldValue = node.key;
		node.setKey(e);
		return oldValue;
	}
	
	/* Insertion Sort in Ascending order */
	@SuppressWarnings("unchecked")
	public void insertionSort(PositionalList<T> L) {
		if(L.size <= 1) return; // no need to sort
		Position<T> marker = L.first();
		Position<T> last = L.last();
		while(marker != last) {
			Position<T> pivot = L.after(marker);
			Comparable<T> value = (Comparable<T>) pivot.key();
			if(value.compareTo(marker.key()) > 1) {
				marker = pivot;
			} else {
				Position<T> walk = marker;
				while(walk != L.first() && ((Comparable<T>) L.before(walk).key()).compareTo((T) value)>1) {
					walk = L.before(walk);
				}
				L.delete(pivot);
				L.addBefore(walk, (T) value);
			}
			
		}
		
	}
	
}
