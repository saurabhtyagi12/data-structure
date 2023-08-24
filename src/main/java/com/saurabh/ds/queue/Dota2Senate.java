package com.saurabh.ds.queue;

import java.util.Queue;
import java.util.ArrayDeque;

// https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
		Queue<Integer> firstQueue = new ArrayDeque<>();
		int n = senate.length();

		for(int i =0; i<n; i++){
			firstQueue.offer(0+senate.charAt(i));
		}

		int lastChar = firstQueue.peek();
		int cnt = 0;
		while(firstQueue.size() > cnt){
			int ch = firstQueue.poll();
			if(lastChar == ch){
				firstQueue.offer(ch);
				cnt++;
			} else {
				cnt--;
				if(cnt == 0) {
					lastChar = firstQueue.peek();
				}
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