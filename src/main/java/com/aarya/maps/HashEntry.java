package com.aarya.maps;

public class HashEntry<K extends Comparable<K>, V> {
	
	private K key;
	private V value;
	
	public HashEntry(K k, V v) {
		key = k;
		value = v;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V v) {
		value = v;
	}
	
	@Override
	public String toString() {
		return "key: " + key.toString() + " | value: " + value.toString();
	}
	
	public boolean equals(HashEntry<K, V> other) {
		return this.key.compareTo(other.getKey()) == 0;
	}
}
