package com.advance.blog.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.advance.blog.entity.BlogPost;

public class BlogObjectDao extends BlogMemoryDao {
	private static final String FILENAME = "blog-object.dat";
	
	public static void main(String[] args) {
		BlogPost post = new BlogPost();
		post.setId(1);
		post.setTitle("das");
		post.setArticle("hok");
		
		writeObj(post);
		readObj();
	}

	private static void readObj() {
		// TODO Auto-generated method stub
		try (FileInputStream fi = new FileInputStream(FILENAME)){
			ObjectInputStream os = new ObjectInputStream(fi);
			Object obj = os.readObject();
			if (obj instanceof BlogPost) {
				BlogPost post = (BlogPost)obj;
				System.out.println(post);
			}
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeObj(BlogPost post) {
		// TODO Auto-generated method stub
		try (FileOutputStream fs = new FileOutputStream(FILENAME)){
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(post);
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
