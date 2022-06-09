package com.theplayer.kits.tutorial;

/**
 * 
 * 	1. analysis problem
 * 	2. divide functions ( method )
 * 	3. define flow of method
 * 	4. more efficially - this game's algorithm : binary search
 * 
 * @author bitcamp
 *
 */
public class UpDown {

	public static void main(String[] args) {
		Left left = new Left();
		Right right = new Right();
		
		left.ready(); // private number (random)
		right.ready();
		
		int min = 0;
		int max = 1000;
		int turn = 0;
		
		boolean isNotCorrected = true;
		do {
			int call = (turn == 0) ? left.call() : right.call(); // so ben doi thu doan
			if( call < min || call > max ){
				System.out.println("you failed call value : " + call);
			}
			int resp = (turn == 0 ) ? right.resp(call) : left.resp(call);
			if( resp < 0 || resp > 2){
				System.out.println("you failed response value : " + resp);
			}
			if( resp == 0) {
				isNotCorrected = false;
				System.out.println( (turn == 0) ? "Winner is Left" : "Winner is Right");
				continue;
			}
//			(turn == 0) ? left.listen(resp) : right.listen(resp);
			if(turn == 0) left.listen(resp); 
			else right.listen(resp);
			
			//Swap
			turn = (turn == 0)? 1 : 0;
//			Robo tmp = left;
//			left = right;
//			right = left;			
			
		}while( isNotCorrected );

		System.out.println("game over");

	}

}
