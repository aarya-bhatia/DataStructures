package com.aarya.maps;

public final class HashUtil {
	public final static int PRIME = 109347;
	public final static int SCALE = (int)(Math.random() * PRIME);
	public final static int SHIFT = (int)(Math.random() * PRIME);
	
	public static int hashOne(String K) {
		int N = 0;
		for(char c: K.toCharArray()) { N += (int) c; }
		return (N * SCALE + SHIFT) % PRIME;
	}
	
	public static int hashTwo(int index) {
		return (PRIME - (PRIME % index));
	}
}