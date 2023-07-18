package com.saurabh.ds;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/bulb-switcher/
public class BulbSwitcher {

    public int bulbSwitch(int n) {
        if(n==0)
        	return 0;
        if(n==1)
        	return 1;

//        int onBulbCnt = 1;
//        for(int i=2; i<= n; i++) {
//        	int divisorCnt = findDivisorCount(i);
//        	if(divisorCnt % 2 == 1) {
//        		onBulbCnt++;
//        	}
//        }
//        
        int onBulbCnt = (int) Math.floor(Math.sqrt(n)) ;
        return onBulbCnt;
    }
    
    private int findDivisorCount(int num) {
		Map<Integer, Integer> divisors = new HashMap<Integer, Integer>();

		long sqrt = Math.round(Math.sqrt(num)) + 1;
		
		for(int i = 2; i <= sqrt; i++) {
			int mod = Math.floorMod(num, i);
			if(mod == 0) {
				int div = num / i;
				divisors.put(i, i);
				divisors.put(div, div);
			}
		}
		// 2 is added for 1 and self number
		return divisors.size() + 2;
	}

	public static void main(String[] args) {
		BulbSwitcher bs = new BulbSwitcher();
		System.out.println("0 --> " + bs.bulbSwitch(0));
		System.out.println("1 --> " + bs.bulbSwitch(1));
		System.out.println("2 --> " + bs.bulbSwitch(2));
		System.out.println("3 --> " + bs.bulbSwitch(3));
		System.out.println("4 --> " + bs.bulbSwitch(4));
		System.out.println("5 --> " + bs.bulbSwitch(5));
		System.out.println("6 --> " + bs.bulbSwitch(6));
		System.out.println("7 --> " + bs.bulbSwitch(7));
		System.out.println("8 --> " + bs.bulbSwitch(8));
		System.out.println("9 --> " + bs.bulbSwitch(9));
		System.out.println("10 --> " + bs.bulbSwitch(10));
		for(int i=11; i< 17; i++) {
			System.out.println(i+ " --> " + bs.bulbSwitch(i));			
		}
		// 1000000
		System.out.println("1000000 --> " + bs.bulbSwitch(1000000));
	}
}
