package com.advance.classes;

public class Main {

	public static void main(String[] args) {
		
		Object o1 = new Object();
		o1.hashCode();
		
		String s1 = "James";
		String s2 = "James";
		
		byte[] ar1 = s1.getBytes();
		System.out.println(ar1 + " " +s1.hashCode());
		
	}
}
