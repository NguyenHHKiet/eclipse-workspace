package com.theplayer.kits;

import java.io.IOException;
import java.util.Scanner;

public class StudentOut {
	
	public static void main(String[] args) throws IOException {
		// TODO: A.B co A trong B
//		System.out.print("Hello Student!! ");
//		System.out.print("\n" + 220);
//		
//		System.out.println();
		
		int val = System.in.read(); //ASCII
		System.out.println(val);
		System.out.println((char)val);
		val = System.in.read();
		val = System.in.read();
		
		while(val != -1) {
			val = System.in.read();
		}
		
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		sc.nextDouble();
		sc.nextLine(); // \n
		
		sc.close();
		
	}
}
