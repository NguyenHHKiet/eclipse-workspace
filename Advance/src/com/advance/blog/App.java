package com.advance.blog;

import java.util.Scanner;
import com.advance.blog.service.BlogService;
import com.advance.blog.dao.BlogMemoryDao;

/**
 * @author NguyenHHKiet
 * @email  1851050073kiet@ou.edu.vn
 * 
 * */

public class App {

	public static void main(String[] args) {
		//
		new BlogService();
		App.run(new BlogService(new BlogMemoryDao()) );
	}

	private static void run(BlogService service) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String cmd;
		
		do {
			System.out.println();
			cmd = sc.nextLine();
		}while(!"exit".equals(cmd));
		System.out.println("terminated");
		sc.close();
	}
}
