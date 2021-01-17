package com.aarya.lists;

public class DoublyLinkedListBase<T> {
	
	static class Node<T> {
		protected T key;
		protected Node<T> next;
		protected Node<T> prev;
		
		public Node(T s) {
			key = s;
			next = null;
			prev = null;
		}
		
		public Node(T s, Node<T> before, Node<T> after) {
			key = s;
			prev = before;
			next = after;
		}
		
		public void setKey(T e) {
			key = e;
		}
		
		public void setNext(Node<T> n) {
			next = n;
		}
		
		public void setPrev(Node<T> p) {
			prev = p;
		}
	}
	
	/** List guards */
	Node<T> header;
	Node<T> trailer;
	
	int size;
	
	public DoublyLinkedListBase() {
		header = new Node<T>(null);
		trailer = new Node<T>(null);
		header.next = trailer;
		trailer.prev = header;
		size = 0;
	}
	
	protected boolean isEmpty() {
		return size == 0;
	}
	
	protected Node<T> insertBetween(T element, Node<T> nodeBefore, Node<T> nodeAfter) {
		Node<T> newNode = new Node<T>(element, nodeBefore, nodeAfter);
		nodeBefore.next = newNode;
		nodeAfter.prev = newNode;
		size++;
		return newNode;
	}
	
	protected T deleteNode(Node<T> nodeToRemove) {
		Node<T> nodeBefore = nodeToRemove.prev;
		Node<T> nodeAfter = nodeToRemove.next;
		nodeBefore.next = nodeAfter;
		nodeAfter.prev = nodeBefore;
		size--;
		T keyToReturn = nodeToRemove.key;
		nodeToRemove = null;
		return keyToReturn;
	}
}