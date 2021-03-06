package com.advance.blog;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.advance.blog.service.BlogService;
import com.advance.blog.dao.BlogFileDao;
import com.advance.blog.dao.BlogMemoryDao;
import com.advance.blog.dao.BlogObjectDao;

/**
 * @author NguyenHHKiet
 * @email  1851050073kiet@ou.edu.vn
 * 
 * */

public class App {

	public static void main(String[] args) {
		//call static method
		//dependency injection
		new BlogService();
//		App.run(new BlogService(new BlogMemoryDao()) );
		App.run(new BlogService(new BlogFileDao()) );
		
	}

	private static void run(BlogService service) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String cmd;
		
		do {
			System.out.println("cmd > ");
			cmd = sc.nextLine();
			
			Map<String, String> map = service.process(cmd);
			
			Set<String> keys = map.keySet();

			for (String key : keys) {
				System.out.println(key + " : " + map.get(key));
			}
			
		}while(!"exit".equals(cmd));
		System.out.println("terminated");
		sc.close();
	}
}
