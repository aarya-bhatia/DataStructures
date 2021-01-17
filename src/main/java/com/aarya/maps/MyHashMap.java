package com.aarya.maps;

public class MyHashMap<K extends Comparable<K>,V> implements MapBase<K, V> {
	
	private final static int TABLE_SIZE = 11;
	private int SIZE = 0;
	private HashEntry<K, V> DEL = new HashEntry<>(null, null);
	private HashEntry<K, V> TABLE[];
	
	@SuppressWarnings("unchecked")
	public MyHashMap() {
		this.TABLE = new HashEntry[TABLE_SIZE];
	}
	
	private int hashOne(K key) {
		return HashUtil.hashOne(key.toString()) % MyHashMap.TABLE_SIZE;
	}
	
	private int hashTwo(int i) {
		return HashUtil.hashTwo(i) % MyHashMap.TABLE_SIZE;
	}
	
	/* Check whether key of entry at given index equals to given key */
	private boolean match(int index, K key) {
		return this.TABLE[index] != null 
				&& this.TABLE[index] != this.DEL 
				&& this.TABLE[index].getKey().compareTo(key) == 0;
	}
	
	/* Find the next available spot in the hash table */
	private int nextSpot(int h1, int h2, int i) {
		return (h1 + h2 * i) % MyHashMap.TABLE_SIZE;
	}
	
	/* Check whether the spot at this index is available for new entry */
	private boolean isFreeSpot(int index) {
		return this.TABLE[index] == null || this.TABLE[index] == this.DEL;
	}


	@Override
	public HashEntry<K, V> get(K key) {
		int h1 = this.hashOne(key);
		if(this.match(h1, key)) {
			return this.TABLE[h1];
		}
		HashEntry<K, V> found = null;
		int h2 = this.hashTwo(h1);
		int i = 1;
		while(true) {
			int index = this.nextSpot(h1, h2, i);
			
			if(index == h1) {
				break;
			}
			
			if(this.match(index, key)) {
				found = this.TABLE[h1];
				break;
			}
		}
		
		return found;
	}


	@Override
	public void put(K key, V value) {
		if(this.SIZE == MyHashMap.TABLE_SIZE) {
			System.out.println("Table is full!");
			return;
		}
		
		HashEntry<K, V> entry = new HashEntry<K, V>(key, value);
		
		int h1 = this.hashOne(key);
		
		if(this.TABLE[h1] == null) {
			this.TABLE[h1] = entry;
			this.SIZE++;
			System.out.println("Added -> " + entry.toString());
			return;
		}
	
		int h2 = this.hashTwo(h1);
		int i = 1;
		while(true) {
			int index = this.nextSpot(h1, h2, i);
			
			/* we are stuck in a cycle */
			if(index == h1) {
				System.out.println("Unable to add entry -> " + entry.toString());
				return;
			}
			
			/* A valid spot can have contain DEL or nothing */
			if(this.isFreeSpot(index)) {
				this.TABLE[index] = entry;
				System.out.println("Added -> " + entry.toString());
				break;
			}
	
			i++;
		}
		
		this.SIZE++;
	}


	@Override
	public HashEntry<K, V> remove(K key) {
		int h1 = this.hashOne(key);
		int h2 = this.hashTwo(h1);
		int i = 1;
		HashEntry<K, V> found = null;
		if(this.match(h1, key)) {
			found = this.TABLE[h1];
			this.TABLE[h1] = this.DEL;
			this.SIZE--;
			return found;
		}
		
		while(true) {
			int index = this.nextSpot(h1, h2, i);
			
			
//			if(index == h1) {
//				break;
//			}
			
			if(this.match(index, key)) {
				found = this.TABLE[h1];
				this.TABLE[h1] = this.DEL;
				break;
			}
		}
		
		if(found != null) {
			this.SIZE--;
		}
		return found;
	}
	
	public void print() {
		for(int i = 0; i < MyHashMap.TABLE_SIZE; i++) {
			if(this.TABLE[i] != null && this.TABLE[i] != this.DEL) {
				HashEntry<K, V> e = this.TABLE[i];
				System.out.println(e.getKey() + " -> " + e.getValue());
			} else {
				System.out.println("_");
			}
		}
	}
	
}

