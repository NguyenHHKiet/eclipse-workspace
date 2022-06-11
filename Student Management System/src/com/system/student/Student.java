package com.system.student;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private int ID;
	private String courses = "";
	private int tuitionBalance;
	private static int costOfCourse = 600;
	private static int id = 1000;
	public Scanner sc;
	public Student std;
	{
		sc = new Scanner(System.in);
		
	}
	
	//Constructor: Student's name and year
	public void addStudent() {
		std = new Student();
		System.out.println("Enter first name: ");
		firstName = sc.nextLine();
		
		System.out.println("Enter last name: ");
		lastName = sc.nextLine();
		
		System.out.println("1 - Freash\n2 - Sophmore\n3 - Junior\n4 - Senior");
		System.out.println("Enter grade year: ");
		gradeYear = sc.nextInt();
		
		sc.nextLine();
		
		std.setFirstName(firstName);
		std.setLastName(lastName);
		std.setGradeYear(gradeYear);
		std.setID();
		System.out.println(std.getFirstName() + " " + std.getLastName() + " " + std.getGradeYear() + " " + std.getID());
		
	}
	// General ID unique
	public void setID() {
		id++;
		this.ID = id;
	}
	//enroll in courses
	public void enroll() {
		do {
			System.out.print("Enter enroll courses (Q to Quite): ");
			String course = sc.nextLine();
			if(!course.equals("Q")) {
				courses = courses + "\n" + course +" - "+ std.getID();
				tuitionBalance = tuitionBalance + costOfCourse;
			}else {
				System.out.println("BREAK!!");
				break;
			}
		}while(true);
		
		std.setCourses(courses);
		std.setTuitionBalance(tuitionBalance);

		System.out.println("ENROLL : " + std.getCourses());
		System.out.println("TUITION BALANCE : " + std.getTuitionBalance());
	}
	
	//view balance
	public void viewBalance() {
		System.out.println("YOUR BALANCE : $" + std.getTuitionBalance());
	}
	//pay
	public void payTuition() {
		System.out.println("Enter payment $:");
		int payment = sc.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for payment of $" + payment);
		std.setTuitionBalance(tuitionBalance);
		viewBalance();
	}
	//show status
	public String showInfo() {
		return "Name: " + std.getFirstName() +" "+ std.getLastName()
				+"\nGrade Year: " + std.getGradeYear()
				+"\nCourses Enrolled: " + std.getCourses()
				+"\nBlance: $" + std.getTuitionBalance();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGradeYear() {
		return gradeYear;
	}

	public void setGradeYear(int gradeYear) {
		this.gradeYear = gradeYear;
	}

	public int getID() {
		return ID;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public int getTuitionBalance() {
		return tuitionBalance;
	}

	public void setTuitionBalance(int tuitionBalance) {
		this.tuitionBalance = tuitionBalance;
	}
	
	
}
