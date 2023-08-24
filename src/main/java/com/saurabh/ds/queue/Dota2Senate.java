package com.saurabh.ds.queue;

import java.util.Queue;
import java.util.ArrayDeque;

// https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        boolean isRadiant = true;
		Queue<Character> firstQueue = new ArrayDeque<>();
		Queue<Character> secondQueue = new ArrayDeque<>();
		int n = senate.length();

		for(int i =0; i<n; i++){
			firstQueue.offer(senate.charAt(i));
		}

		boolean skipNext = false;
		char lastChar = firstQueue.peek();
		int cnt = 0;
		boolean isDiffChar = false;
		while(!firstQueue.isEmpty()){
			char ch = firstQueue.poll();
			if(lastChar == ch){
				secondQueue.offer(ch);
				cnt++;
			} else {
				cnt--;
				isDiffChar = true;
				if(cnt == 0) {
					if(!firstQueue.isEmpty())
						lastChar = firstQueue.peek();
					else
						lastChar = secondQueue.peek();
				}
			}
			if(firstQueue.isEmpty()){
				if(!isDiffChar){
					if(lastChar == 'D')
						isRadiant = false;
					break;
				} else {
					firstQueue = secondQueue;
					secondQueue = new ArrayDeque<>();
					isDiffChar = false;
				}
			}
		}
		
		if(isRadiant)
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