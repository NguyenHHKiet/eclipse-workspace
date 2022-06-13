package com.advance.classes;

public class Simsim {

	public void hello(String arg) {
		// TODO Auto-generated method stub
		arg.split("/");
	}

	public void say(Object arg) {
		// TODO Auto-generated method stub
		System.out.println(arg.getClass().getName());
		if(arg instanceof Integer) {
			System.out.println("hi integer");
		} else if(arg instanceof Double) {
			System.out.println("hi double");
		} else if(arg instanceof String) {
			System.out.println("hi string");
		}
	}

	public <T> void bye(T param) {
		// TODO Auto-generated method stub
		System.out.println(param);//.toString()
		param.getClass().getFields();
		param.getClass().getMethods();
		
	}

}
