package com.theplayer.baseball.*;

import java.util.HashMap;
import java.util.Map;


public class Team01 implements Player {
	private int answer;
	private int call;
	private boolean[] flag;
	private int lengthNumber;
	private int tram;
	private int chuc;
	private int dv;
	private int[] number1;
	private int caseLocation;
	private int iValue;
	private int iTry;
	@Override
	public void ready() {	
		iTry = 0;
		iValue = 0;
		call = 123;
		lengthNumber = 9;
		number1 = new int[]{1,2,3,4,5,6,7,8,9};
		caseLocation = 0;
		flag = new boolean[9];
		flag[0]=true;
		int r;
		int number = 0;
		for(int i = 1;i<=3;i++) {
		
			do {
				r = (int)(Math.random() * 1000)%flag.length;
			}while(flag[r]);
			number = number*10+r;
			flag[r] = true;
		}
		setAnswer(number);
	}
	@Override
	public Map<String, Integer> reply(int value) { //map(strike,result) + map(ball,result)
		int strike = 0;
		int ball = 0;
		int a = answer;
		for(int i = 0; i < 3; i+=1) {
			int iv = a % 10;
			a /= 10;
			int v = value;
			for(int k = 0; k < 3; k+=1) {
				int kv = v % 10;
				v /= 10;
				if( iv == kv ) {
					if( i == k ) {
						strike += 1;
					}else {
						ball += 1;
					}
				}				
			}
		}
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("strike", strike);
		map.put("ball", ball);
		return map;
	/*
		int strike = 0;
		int ball = 0;
		int temp1 = answer;
		int temp2 = value;
		for (int i = 0;i<3;i++) {
			int k1 = temp1%10;
			temp1 /= 10;
			for (int j=0;j<3;j++) {
				int k2 = temp2%10;
				temp2 /= 10;
				if (k1 == k2) {
					if (i == j) {
						strike ++;
					}
					else {
						ball++;
					}
				}
			}
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("strike", strike);
			map.put("ball", ball);
			return map;
			*/
	}

	@Override
	public int call() { //call = doan
		return call;
	}

	@Override
	public void predict(int strike, int ball) { //du doan
		tram = call/100;
		chuc = call/10%10;
		dv = call % 10;
		
		int[] number2 = new int[3];
		number2[0] = tram;
		number2[1] = chuc;
		number2[2] = dv;
		
		int total = strike + ball;
		if(total == 3) {
			caseLocation++;
			switch(caseLocation){
			case 1:
				call = tram*100+chuc*10+dv; // 123
			break;
			case 2:
				call = tram*100+chuc+dv*10; //132
			break;
			case 3:
				call = tram*10+chuc*100+dv; //213
			break;
			case 4:
				call = tram+chuc*100+dv*10; //231
			break;
			case 5:
				call = tram+chuc*10+dv*100; //321
			break;
			case 6:
				call = tram*10+chuc+dv*100; //312
			break;
			}
		}
		else if (total == 0) {
			for(int j1 = 0;j1<3;j1++) {
				for(int j2 = 0; j2<lengthNumber;j2++) {
					if(number1[j2]==number2[j1]) {
						number1[j2] = number1[j2+1];
						for(int j3=j2+1;j3<lengthNumber-1;j3++) {
							number1[j3]=number1[j3+1];
						}
					}
				}
				lengthNumber--;
			}
			
		}
		
			if(total != 3) {
				int iValue1 = iValue + 1;
				int iValue2 = iValue + 2;
				
				if (iTry != 0) {
					//thay doi dv
						while(iValue2<lengthNumber) {
						do {
							iValue2 += iTry;
						}while((iValue2==iValue1)||(iValue2==iValue));
						if(iValue2 >= lengthNumber) {
							iValue2 = 0;
						}
						if((iValue2!=iValue)&&(iValue2!=iValue1)) {
							break;
						}
						}
				}
				else {
					if(strike == 2) {
						iTry ++;
					}
					if(iTry != 0) {
						if(strike == 1) {
							
						}
					}
					if(iValue>=lengthNumber) {
						iValue = 0;
						iValue1 = 1;
						iValue2 = 2;
					}
					
					if(iValue1>=lengthNumber) {
						iValue1 = 0;
						iValue2 = 1;
					}
					if(iValue2>=lengthNumber) {
						iValue2 = 0;
					}
					tram = number1[iValue];
					chuc = number1[iValue1];
					dv = number1[iValue2];
					call = tram*100+chuc*10+dv;
					if(iTry == 0) {
						iValue++;
					}
				}
			}
		}
	
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}

}