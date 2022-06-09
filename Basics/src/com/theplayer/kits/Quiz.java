package com.theplayer.kits;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
//		quiz01();
//		quiz02(2);
		quiz03(3);
		
	}
	
	
	private static void quiz01() {
		/*TODO: 1 ~ 27 1++ -> print
			5 number on line
		*/
		
		for(int i = 1; i < 28; i++)
		{
			System.out.print(i + " ");
			if(i % 5 == 0) {
				System.out.println("");
			}
		}
	}
	
	private static void quiz02(int row) {
		/*TODO: tham so la so cot cua bang cuu chuong
		*/
		
//		System.out.println(15);
		
//		int kq = 0;
//		int a = 10;
//		int b = 10;
//		
//		int i =1;
//		int j =1;
//		int ko = 1;
		
			
		
//			for(i=1;i <= 9; i++) {
//				ko = row;
//				
//				for(j = 1; j<=ko; j++) {
//					kq = i * j;
//					System.out.print(j + "x" + i + "=" + kq + "\t");
//					
//				}
//				
//				if(j == (ko + 1)) {
//					System.out.println();
//				}
//				
//				j = j / ko;
//				ko++;
//				
//				
//				
//			}
//			int cb = ko + row ;
//			if(cb > 10) {
//				cb = 10;
//			}
//			System.out.println(ko);
//
//			for(i=1;i<=9;i++) {
//				
//				for(j = ko; j<=cb - 1; j++) {
//					kq = i * j;
//					System.out.print(j + "x" + i + "=" + kq + "\t");
//				}
//				
//				
//				System.out.println();
//				
//				if(i == 9 && ko != 9) {
//					ko = ko + row;
//				}
//
//				
//			}
//			
//
//			System.out.println(ko);	
		
		
		
		for(int base = 2; base <= 9; base+= row) {
			for(int v = 1; v <= 9; v+=1) {
				for(int a=0; a < row;a+=1) {
					int dan = base + a;
					int multi = dan * v;
					if(dan <= 9) {
						System.out.print(dan+"x"+a+"="+multi+"\t" );
					}
				}
				System.out.println();
			}
		}
			
		
	}
	
	private static boolean isDuplicated(int number, int r) {
		while(number > 0){
			if(number % 10 == r) {
				return true;
			}
			number /= 10;
		}
		return false;
	}
	
	private static void quiz03(int digits) {
		
//		int max = 9;
//		int min = 1;
//		int sl = 0;
//		
//		
//		for(int i = 0; i < 20; i++) {
//			int a = (int) (Math.random() * 1000);
//			a = a % (max - min + 1);
//			a = a + min;
//
//			int b = (int) (Math.random() * 1000);
//			b = b % (max - min + 1);
//			b = b + min;
//
//			int c = (int) (Math.random() * 1000);
//			c = c % (max - min + 1);
//			c = c + min;
//			
//			if(a != b && a != c && b != c) {
//				System.out.print(a +""+ b +""+ c + "\t");
//				sl++;
//			}
//			if(sl == 5) {
//				break;
//			}
//			
//		}
		
		int r = 0;
		
		for(int i = 0; i < 8; i+=1) {
			int number = 0;
			for(int j = 0;j < digits; j++) {
				do {
					r = (int) (Math.random() * 10);
					
				}while(isDuplicated(number, r));
				number = number * 10 + r;
			}
			System.out.println(number);
		}
	
		
		
	}
	
}
