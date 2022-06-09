package com.system.student;

import java.util.Scanner;

public class Services {

	private static Scanner sc;
	private static Student stds[];
	
	static {
		sc = new Scanner(System.in);
		stds = new Student[5];
	}
	public static void main(String[] args) {
		int i=0;
		boolean exit = false;

		do {
			System.out.println("Enter cmd: ");
			System.out.println("1	2	3	4	Exit ");
			String cmd = sc.nextLine();
			
			switch(cmd) {
				case "1":
					Student std1 = Add();
					if(i < stds.length) {
						stds[i] = std1;
						i++;
					}
					break;
				case "2":
					System.out.println("Enter find name: ");
					String name = sc.nextLine();
					Student std2 = new Student();
					std2 = Find(name);
					
					System.out.println("Info: "+ std2.getRoll()  + std2.getName());
						break;
				case "3":
					System.out.println("Enter delete: ");
					int roll = sc.nextInt();
					boolean std3 = Delete(roll);
					if(std3) {
						System.out.println("Successful delete!!");
					}else {
						System.out.println("Fail");
					}
					break;
			}
			
			
		}while(!exit);
		
		sc.close();
	}
	
	private static Student Add() {
		Student std = new Student();
		
		System.out.println("ID: ");
		int id = sc.nextInt();
		System.out.println("Name: ");
		String name = sc.nextLine();
		
		sc.nextLine();
		
		std.setRoll(id);
		std.setName(name);
		
		
		return std;
	}
	
	private static Student Find(String name) {
		Student tam = null;
		for(int i = 0 ; i < stds.length; i++) {
			if(stds[i] != null) {
				if(stds[i].getName().equals(name)) {
					tam = stds[i];
				}
					
			}
		}
		return tam;
		
	}
	private static boolean Delete(int roll) {
		boolean status = false;
		
		for(int i = 0 ; i < stds.length; i++) {
			if(stds[i] != null) {
				if(stds[i].getRoll() == roll) {
					stds[i] = null;
					status = true;
				}
					
			}
		}
		return status;
		
	}
	
}
