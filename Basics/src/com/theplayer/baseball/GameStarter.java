package com.theplayer.baseball;
import java.io.IOException;
import java.util.Map;


public class GameStarter {
	public static void main(String[] args) throws IOException {
		Player[] robot = { null, new Team01(), new Team02()};
		int[] score = new int[robot.length];
		
		for(int p1=1; p1 < robot.length;p1++) {
			for(int p2=1; p2 < robot.length;p2++) {
				if( p1 != p2 ) {
					int caller = p1; //team 1
					int replier = p2;//team 2
					System.out.println((p1)+" vs "+(p2));
					deplay(1000);
					robot[caller].ready(); //759
					robot[replier].ready();//759
					while(true) {
						//xet dk cac gia tri trung
						int value = robot[caller].call(); //so du doan cua team 1 (cho private num cua team 2)
						if( invalid(value) ) {
							System.out.println((caller)+" team failed");
							deplay(3000);
							score[replier]++; //score cua team2 tang len
							break;
						}
						//
						Map<String, Integer> map = robot[replier].reply(value); //strike, ball
						if( invalid(map) ) {
							System.out.println((replier)+" team failed");
							deplay(3000);
							score[caller]++;
							break;
						}
						//
						int strike = map.get("strike"); // lay strike ra
						int ball = map.get("ball");     // lay ball ra 
						System.out.println((caller)+"["+value+"] -> "+(replier)+"[S: "+strike+", B: "+ball+"]");
						
						
						if(strike == 3 ) { //strike ==3
							System.out.println((caller)+" team win"); //team 1
							deplay(3000);
							score[caller]++; 
							break;
						}
						//
						robot[caller].predict(strike, ball);
						
						int tmp = caller;
						caller = replier;						
						replier = tmp;
					}
				}
			}			
		}
		
		for(int i=1; i < robot.length;i++) {
			System.out.println("team["+(i)+"]\t"+score[i]);
		}

	}

	private static boolean invalid(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		if( map == null || map.get("strike") == null || map.get("ball") == null) {
			System.out.println("replier failed to return Map<>");
			return true;
		}
		int value = map.get("strike") + map.get("ball");
		if ( value > 3 || value < 0) {
			System.out.println("replier invalid value");
			return true;
		}
		return false;
	}

	private static boolean invalid(int value) {
		// TODO Auto-generated method stub
		if( value < 123 || value > 987 ) {
			System.out.println("caller invalid value");
			return true;
		}
		int a = value / 100;
		int b = value / 10 % 10;
		int c = value % 10;
		if( (a==b) || (a==c) || (b==c) ) {
			System.out.println("caller duplicated value");
			return true;
		}
		return false;
	}

	private static void deplay(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}