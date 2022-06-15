package com.advance.blog;

import java.util.*;

public class SetMapIterator {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Set<String> set = new HashSet<String>();
		Set<Integer> set = new HashSet<Integer>();
//		set.add("NguyenHHKiet");
//		set.add("Qliphort Shell");
//		set.add("HoangKiet");
//		set.add("22 year old");
//		set.add(null);
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		
		System.out.println("Set : " + set);
		
//		for (String key : set) {
//			System.out.println(set);
//		}
		
		Iterator<Integer> i = set.iterator();
		
		while (i.hasNext()) {
			int n = i.next();
			if(n==4) i.remove();
			System.out.println(i.next());
		}
		
		
		
		
//		Set<String> set = new HashSet<String>();
//		
//		set.add("NguyenHHKiet");
//		set.add("Qliphort Shell");
//		set.add("HoangKiet");
//		set.add("22 year old");
//		
//		
//		System.out.println("Set : " + set);
//		
//		// Creating an iterator
//        Iterator<String> value = set.iterator();
//  
//        // Displaying the values after iterating through the iterator
//        System.out.println("The iterator values are: ");
//        while (value.hasNext()) {
//            System.out.println(value.next());
//        }
	}
}
