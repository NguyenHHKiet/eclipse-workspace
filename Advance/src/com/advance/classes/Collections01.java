package com.advance.classes;

import java.util.*;

/*
 * 1. Định nghĩa class có method + - * / 12bytes
 * - carry ?
 * 2. String instance chứng minh tính hữu hạn trong bộ nhớ memory?
 * - String s = "james";
 * 3. 
 * 
 * */

public class Collections01 {
	
	public static void main(String[] args) {
		
		Set<String> set1 = new HashSet<String>();
		List<String> list1 = new ArrayList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		
		set1.add("first");
		list1.add("first");		
		map1.put("first", 10);
		
		set1.add("first");
		list1.add("first");		
		map1.put("first", 10);
		
		System.out.println(set1.size());
		System.out.println(list1.size());
		System.out.println(map1.size());
		
		//set List - Map is key : value
		//elements : index (int) and name (String)
		
//		DAO inst = new ArrayDAO();
////		inst.create(Integer.valueOf(100));
//		List list = new ArrayList<String>();
		
	}

	public static void main1(String[] args) {
		Simsim sime = new Simsim();
		sime.bye(Integer.valueOf(100));
		sime.bye(new String("james"));
		// client use instance of simsim
//		Simsim sime = new Simsim();
		sime.hello("/members/list");
		
		//client decide type
		sime.say(new Integer(100));
		sime.say(new Double(10.0));
		sime.say(new String("10.0"));
	}
}
