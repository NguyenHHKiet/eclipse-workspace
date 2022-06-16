package com.advance.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingTextFile {

	public static void main(String[] args) {
		File file = new File("example.txt");
		
		FileWriter fw = null;
		BufferedWriter br = null;
		
		try {
			
			fw = new FileWriter(file);
			br = new BufferedWriter(fw);
			
			br.write("this is line one\n");
			
			br.write("this is line two\n");
			br.write("this is line two\n");
			
			br.write("last end");
			
			br.close();
			
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("error to read file " + file.toString() );
		}
		try {
			fw.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
