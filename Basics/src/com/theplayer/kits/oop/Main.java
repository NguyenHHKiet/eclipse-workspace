package com.theplayer.kits.oop;

public class Main {

	public static void main(String[] args) {
		Robot robo1 = new RobotAbsImpl();
		Robot robo3 = new RobotImpl() {

			@Override
			public void shoot(Object args) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		
		Robot robo2 = new Robot() { //<- anonymous class
			@Override
			public void forward() {
				// TODO Auto-generated method stub
				robo3.forward();
			}

			@Override
			public void turnLeft(int degree) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void turnRight(int degree) {
				// TODO Auto-generated method stub
				
			}
		};
		
	}
}
