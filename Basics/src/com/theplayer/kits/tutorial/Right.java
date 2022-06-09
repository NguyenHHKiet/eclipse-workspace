package com.theplayer.kits.tutorial;

public class Right {
	private int number;
	private int resp;
	
	public void ready() {
		
		int min = 0, max = 1000;
		
		int number = (int) ( Math.random() * 1000000);
		number = number % (max + 1 - min);
		number = number + min; 
		System.out.println("Ready!");
		System.out.println("Number: " + number);
		this.number = number;
		
	}
	
	private int min = 0, max = 1000;
	public int call() {	
		int mid = (min + max) / 2;
		
		if (resp == 1) {
			min = mid;
		} else {
			max = mid;
		}
		
		mid = (int) ( Math.random() * 1000000);
		mid = mid % (max + 1 - min);
		mid = mid + min;
		
		System.out.println("Guess number: " + mid);
		return mid;
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
	
	
	public void listen(int resp) {
		this.resp = resp;
	}
}
