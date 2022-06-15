package com.advance.fileio;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		md1();
	}
	
	private static void md1() {
		// TODO Auto-generated method stub
		String[] as = new String[3];
		/*
		 * 1. dot : left not null
		 * 2. = ? reference var = null
		 * */
		for (int i = 0; i < 10; i++) {
			try {
				as[i].charAt(i);
				System.out.println(as[i]);
				System.out.println("dadadasdadasdasd");
			} catch (Exception e) {
				// TODO: handle exception
//				System.out.println(as[i]);
				System.out.println("oopeerrr");
			}
		}
		System.out.println("end loop");
	}
	
	private void md2() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		try {
			int num = sc.nextInt();
			System.out.println(num);			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			sc.close();
			System.out.println("The End!!");
		}
	}
	
	private void md3() throws Exception {
		// TODO Auto-generated method stub
		throw new Exception();
	}
	
	
	
	
	
	
	
	
	
	
}
