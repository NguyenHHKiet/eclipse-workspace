package com.system.student;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.print("Enter number enroll: ");
		Scanner i = new Scanner(System.in);
		int num = i.nextInt();
		Student[] s = new Student[num];
		
		
		for(int n = 0; n < num; n++) {
			s[n].addStudent();
			s[n].enroll();
			s[n].payTuition();
			
		}
		
		for(int n = 0; n < num; n++) {
			System.out.println(s[n].showInfo().toString());
		}
		i.close();
	}
}
