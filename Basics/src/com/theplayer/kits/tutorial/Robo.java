package com.theplayer.kits.tutorial;

public class Robo {
	private int mynumber;
	private int babo;
	void ready(){
		mynumber = genNumber();
		babo = -1;
	}
	int call(){
		babo += 1;
		return babo;
	}
	int resp(int call){
		if( mynumber == call ){
			return 0;
		}else if( mynumber > call){
			// UP
			return 1;
		}else{
			// Down
			return 2;
		}
	}
	void listen(int resp) {
		if( resp == 1){
			// UP
			System.out.println("i dont know how to do when UP");
		}
		if( resp == 2){
			// DOWN
			System.out.println("i dont know how to do when DOWN");
		}
		
	}

	private int genNumber(){
		return (int)( Math.random()*100000 ) % 1001;
	}

}
