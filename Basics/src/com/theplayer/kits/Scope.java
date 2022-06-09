package com.theplayer.kits;

class Data{
	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
}

public class Scope {

	private int InsVar; //instance variable
	private static int ClassVar;//class variable
	int a = 10;
	
	public static void main(String[] args) {//class method
		Scope o = new Scope();// instance
		
		
		
		{ //block scope
		System.out.println(o.sum(5,5));
		}
	}
	
	private int sum(int a, int b) {
		// TODO Auto-generated method stub
		return (a + b);
	}

	public void todo() {
		a = 20;
	}
	
//	public static void main(String[] args) {//class method
//		Scope o = new Scope();// instance
//		
//		Scope.ClassVar = 10;
//		o.InsVar = 110;
//		
//		System.out.println();
//	}
}
