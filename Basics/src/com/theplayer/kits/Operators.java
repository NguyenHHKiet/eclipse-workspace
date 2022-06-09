package com.theplayer.kits;

public class Operators {
	
	public static void main(String[] args) {
		ariths();
	}
	
	private static void logic() {
		/*
		 * &&
		 * ||
		 * !
		 * */
	}
	
	
	private static void compare() {
		/*
		 * <
		 * >
		 * =>
		 * =<
		 * !=
		 * */
	}
	
	private static void ariths() {
		int min = 37;
		int max = 117;
		
		
		int a = (int) (Math.random()*1000);
		
		a = a % (max + 1 - min);
		a = a + min;
		System.out.println((char)a);
		
		
	}
}
