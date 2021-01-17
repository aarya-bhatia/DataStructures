package com.aarya.maps;

public interface MapBase<K extends Comparable<K>, V> {
	
	public HashEntry<K, V> get(K key);
	
	public void put(K key, V value);
	
	public HashEntry<K, V> remove(K key);
}
