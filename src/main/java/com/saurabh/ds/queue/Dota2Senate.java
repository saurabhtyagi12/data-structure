package com.saurabh.ds.queue;

import java.util.Queue;
import java.util.ArrayDeque;

// https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
		int n = senate.length();
		int[] firstQueue = new int[n];

		for(int i =0; i<n; i++){
			firstQueue[i] = senate.charAt(i);
		}

		int lastChar = firstQueue[0];
		int cnt = 0;
		int lastindex = 0;
		int i =0;
		while(n > cnt){
			int ch = firstQueue[i];
			i++;
			if(lastChar == ch){
				firstQueue[lastindex] = ch;
				lastindex++;
				cnt++;
			} else {
				cnt--;
				if(cnt == 0) {
					if(i==n){
						lastChar = firstQueue[0];
					} else {
						lastChar = firstQueue[i];
					}
				}
			}
			if(i==n){
				i=0;
				n=lastindex;
				lastindex=0;
			}
		}
		
		if(lastChar == 'R')
			return "Radiant";
		else
			return "Dire";
    }
	
	public static void main(String[] args) {
		Dota2Senate d2s = new Dota2Senate();
		System.out.println("RD :: " + d2s.predictPartyVictory("RD"));
		System.out.println("RDD :: " + d2s.predictPartyVictory("RDD"));
		System.out.println("DDR :: " + d2s.predictPartyVictory("DDR"));
	}
}