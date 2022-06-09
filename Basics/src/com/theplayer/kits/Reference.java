package com.theplayer.kits;

public class Reference {
	
	public static void main(String[] args) {
		//TODP: point to address(ID)
		Reference inst = new Reference(); //<- constructor
		// return object id(address)
		/*
		 * inst: reference variable, name of instance
		 * */
		System.out.println(inst.toString());
		System.out.println(inst.hashCode());
		System.out.println(inst.getClass().getName());
	}
}
