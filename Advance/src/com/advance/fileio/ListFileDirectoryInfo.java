package com.advance.fileio;

import java.io.File;

/*
 * 
 * */

public class ListFileDirectoryInfo {
	
	public static void main(String[] args) {
		File[] file;
		String current = "src";
		File myDir = new File(current);
	}

	public static void treedir(String[] args) {
		String current = "src";
		boolean loop = true;
		
		
		while (loop) {
			File myDir = new File(current);
			
			if (loop) {
				File[] list = myDir.listFiles();
				
				for (int i = 0; i < list.length; i++) {
					System.out.println(list[i].getName());
					
					if (list[i].isDirectory()) {
						System.out.println("\t\tDIR");
						current = list[i].getName();
						break;
						
						
					}else if(list[i].isFile()) {
						System.out.println("\t\tFILE");
						
					}else {
						System.out.println("\t\tUnknown");
					}
				}
			}else {
				loop = false;
			}
			
		}
		
		
	}
}
