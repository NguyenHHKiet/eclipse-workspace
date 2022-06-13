package com.advance.classes;

//import java.time.Instant;
//import java.util.Date;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;

public class ToData {
	
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		System.out.println(ld);
		System.out.println(lt);

		
//		Locale locale = Locale.getDefault();
//		System.out.println(locale);//.toString()
//		System.out.println(locale.getCountry());
//		System.out.println(locale.getDisplayCountry());
		
	}
	
	public static void main3(String[] args) {
		//1. import
		//2. class, interface,....
		//3. constructor has arguments
		//4. static method
		
//		Instant instant = Instant.now();
//		System.out.println(instant);
//		instant.getNano();
	}
	
	public static void main2(String[] args) {
		// singleton pattern
//		Calendar cal = Calendar.getInstance();//sau tu new la classname
//		System.out.println(cal.get(Calendar.MONTH));
//		for(int i = 0; i<10;i++) {
//			cal = Calendar.getInstance();
//			System.out.println(cal.hashCode());
//		}
	}

	public static void main1(String[] args) {
//		java.util.Date udata = new java.util.Date();
//		
//		String str = udata.toString();
//		System.out.println(str);
//		
//		long lt = udata.getTime();
//		System.out.println(lt);
//		
//		Date date = Date.from(Instant.now());
//		System.out.println(date);
		
//		Date date = new Date(System.currentTimeMillis());
//		Date.from();
		
//		Date date = new Date((long)(52*365*24*3600));
//		System.out.println(date);
		
	}
}
