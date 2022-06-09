package com.theplayer.kits.oop;

public class StaticMember {

	//member
	static int value; // field is variable
	static MemberVO vo; //non static == instance
	
	public StaticMember() { //constructor ko the gan static
		if(vo == null) {
			vo = new MemberVO();
			System.out.println(vo + " in constructor");
		}

	}
	
	void todo() { // method is function
//		vo = new MemberVO();
	}
}
