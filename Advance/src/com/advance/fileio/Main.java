package com.advance.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		md1();
//		instance01();
		useIOstream();
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
	
	
	private static void instance() {
		// TODO Auto-generated method stub
		//don't create url file.txt
		// "/" no cho dia chi nam ngoai ngaoi xa nhat
		String path = "/";
		String fname = "example.txt";//{project}/example.txt
		//file instance
		File fo = new File(path, fname);
		
		if (fo.exists()) {
			System.out.println(fo.isFile() + " <- isFile()");
			System.out.println(fo.isDirectory() + " <- isDirectory()");
			System.out.println(fo.toURI());
			
		}else {
			try {
				fo.createNewFile();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static void instance01() {
		// TODO Auto-generated method stub
		String path = "data/mk/das";//without ext
		File fo = new File(path);
		try {
			fo.createNewFile();
			fo.mkdir();// make directory
			fo.mkdirs();// make directory tree
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void useIOstream() {
		//write
		File file = new File("example.txt");
		
		// output
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			
			byte[] value = new byte[] {48,14,32,51,54,65,80,95};
			os.write(value);
			os.flush(); //phun ra - tuon ra
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//input
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			
			byte[] value = new byte[10];
			
			is.read(value);
			int isEnd = 0;
			while (isEnd  != -1) {
				for (int i = 0; i < value.length; i++) {
					
					if(value[0] == 0)break;
					
					System.out.println(value[i]);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
}
