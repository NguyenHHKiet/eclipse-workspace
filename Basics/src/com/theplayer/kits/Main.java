package com.theplayer.kits;

import java.util.Scanner;

//other package
import com.theplayer.kits.vo.*;

public class Main {
	
	private static Scanner sc;
	private static LoginUser[] users;
	static { //initialize block before constructor
		sc = new Scanner(System.in);
		users = new LoginUser[10];
	}
	
	
	public static void main(String[] args) {
//		//TODO: entry point on console
//		LoginUser user = new LoginUser(); //create instance
//		/*
//		 * user is name of instance of LoginUser
//		 * user is variable point to instance
//		 * */
//		
		
		int seq = 0;
		boolean exit = false;
		do {
			System.out.println("Enter cmd: ");
			String cmd = sc.nextLine();
			if("exit".equals(cmd)) {
				cmd.equalsIgnoreCase("exit");
				exit = true;
			} else if("join".equals(cmd)) {
				LoginUser user = join();
				if(seq < users.length) {
					users[seq] = user;
					seq++;
				}
			}else if("login".equals(cmd)) {
				LoginUser user = login();
				if(user == null) {
					System.out.println("Failes!");
				}else {
					System.out.println("Successfull!!");
				}
			}
		}while(!exit);
		
		
		sc.close();
	}
	
	 private static LoginUser login() {
		 LoginUser user = join();
		 //search
		 for(int i = 0; i < users.length; i++) {
			 if(users[i] != null) {
				 if(users[i].getUserID().equals(user.getUserID())) {
					 if(users[i].getUserName().equals(user.getUserName())) {
						 return users[i];
					 }
				 }
			 }
		 }
		 return null;
	}
	 
	 private static LoginUser join() {
		 LoginUser user = new LoginUser();
		 System.out.println("ID: ");
		 String id = sc.nextLine();
		 System.out.println("PW: ");
		 String pw = sc.nextLine();
		 
		 user.setUserID(id);
		 user.setUserName(pw);
		 
		 return user;
	}
	
}
