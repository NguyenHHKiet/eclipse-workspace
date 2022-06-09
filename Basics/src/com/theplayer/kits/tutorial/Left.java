package com.theplayer.kits.tutorial;

public class Left {
	private int min = 0;
	private int max = 1000;
	private int call;
	private int resp;
	private int answer;
	private int number;
	
	public int call() {
		call = (max+min)/2;
		return call;
	}
	public void ready() {
		answer = 123;
	}
	public int resp(int call) {
		
		int rightNumb = this.number;
		resp = 1;
		
		if (call != rightNumb) {
			if (call < rightNumb) {
				System.out.println("Up!");
			} else if (call > rightNumb) {
				System.out.println("Down!");
				resp = 2;
			}
		} else {
			System.out.println("Correct!");
			resp = 0;
		}
		return resp;
	}
	public void listen(int v) {
		if( v == 1 ) {
			// UP
//			max = call;
			min = call;
		}
		if( v == 2 ) {
			// DOWN
			max = call;
//			min = call;
		}
		
	}
}
