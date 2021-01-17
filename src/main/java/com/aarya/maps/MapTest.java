package com.aarya.maps;

public class MapTest {
	public static void main(String args[]) {
		MyHashMap<String, Integer> test = new MyHashMap<String, Integer>();
		String names[] = {"Aarya", "Adia", "Aditya", "Animesh", "Pragya", "Berry", "Aarya"};
		run(names, test);
		test.print();
	}
	
	public static void run(String[] names, MyHashMap<String, Integer> test) {
		for(String n : names) {
			Integer i = Integer.valueOf((int)(Math.random() * 135));
			test.put(n, i);
		}
	}
	
	//TODO
	public static void removeTest(MyHashMap<String, Integer> test) {
		System.out.println("Test 3");
		System.out.println(test.remove("Berry").toString());
	}
	
	public static void getTest(MyHashMap<String, Integer> test) {
		System.out.println("Test 2");
		System.out.println(test.get("Aditya").toString());
		System.out.println(test.get("Aarya").toString());
	}
}
