package com.theplayer.baseball;
import java.io.IOException;
import java.util.Map;

import java.util.Arrays;
import java.util.HashMap;



public class Team01 implements Player {
	private int answer;
	private boolean[] flag;
	private int 백;
	private int 십;
	private int 일;
	private int done;
	
	@Override
	public void ready() {
		// TODO Auto-generated method stub
		answer = 759;
		flag = new boolean[10];
		Arrays.fill(flag, false);
		백 = 1;
		십 = 백+1;
		일 = 십+1;
		done = 0;
	}

	@Override
	public Map<String, Integer> reply(int value) {//value: cua team doi thu
		// TODO Auto-generated method stub
		int strike = 0;
		int ball = 0;
		
		// Xu ly so cua team minh (team 2)
		int a = answer; //759 cua team dang goi reply
		for(int i = 0; i < 3; i+=1) {
			int iv = a % 10; //9, lay cai so cuoi
			a /= 10;         //75
			
		// Xu ly so cua team doi thu doan (team 1)	
			int v = value;   //v = value doi thu . Gs: 135
			for(int k = 0; k < 3; k+=1) {
				int kv = v % 10; // lay don vi: 5
				v /= 10;         // 13
				if( iv == kv ) { // Xet don vi (team2) va donvi (team1)
					if( i == k ) { // Hang chuc team 2 va team 1 
						strike += 1; //strike cua team 2 (tra cho team 1)
					}else {        // Hang chuc khac nhau
						ball += 1; 
					}
				}				
			}
		}
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("strike", strike);
		map.put("ball", ball);
		return map;
	}

	@Override
	public int call() { //so cua team 2 du doan
		// TODO Auto-generated method stub
		int call=0;
		if( done == 0 ) {
			while(flag[백]) 백 =백%9 +1;
			십 = (백+1)%9+1;
			while(flag[십]) 십 =십%9 +1;
			일 = (십+1)%9+1;
			while(flag[일]) 일 =일%9 +1;
			call = (백*100)+(십*10)+(일);
		}else {
			switch(done) {
			case 1:
				call = (십*100)+(백*10)+(일);// 213
			break;
			case 2:
				call = (백*100)+(일*10)+(십);// 132
			break;
			case 3:
				call = (일*100)+(십*10)+(백);// 321
			break;
			case 4:
				call = (십*100)+(일*10)+(백);// 231
			break;
			case 5:
				call = (일*100)+(백*10)+(십);// 312
			break;
			case 6:
				call = (백*100)+(십*10)+(일);// 123
			break;
			}
			done+=1;
		}
		return call;
	}

	@Override
	public void predict(int strike, int ball) {//tra trike, ball cho team1
		// TODO Auto-generated method stub
		if( strike == 0 && ball == 0 ) {
			flag[백] = true; // hang 100
			flag[십] = true; // hang 10
			flag[일] = true; // hang 1
		}
		if( strike + ball == 3 ) {
			done = 1;
		}else {
			백 += 1;
		}
	}

}