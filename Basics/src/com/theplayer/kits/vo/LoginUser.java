package com.theplayer.kits.vo;

/*
 * public (default) 	> method
 * protected 			> family
 * private 				> fields
 * */

public class LoginUser {

	private String userID;//
	private String userName;//
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public static void main(String[] args) {
		LoginUser user = new LoginUser();
		System.out.println(user);
	}
}
