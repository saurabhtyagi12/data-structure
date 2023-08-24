package com.saurabh.ds.queue;

import java.util.Queue;
import java.util.ArrayDeque;

// https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        boolean isRadiant = true;
		Queue<String> firstQueue = new ArrayDeque<>();
		Queue<String> secondQueue = new ArrayDeque<>();
		int n = senate.length();

		for(int i =0; i<n; i++){
			firstQueue.offer(""+senate.charAt(i));
		}

		boolean skipNext = false;
		String lastChar = firstQueue.peek();
		int cnt = 0;
		while(!firstQueue.isEmpty()){
			String ch = firstQueue.poll();
			if(lastChar.equals(ch)){
				secondQueue.offer(ch);
				cnt++;
			} else {
				cnt--;
				if(cnt == 0) {
					if(!firstQueue.isEmpty())
						lastChar = firstQueue.peek();
					else
						lastChar = secondQueue.peek();
				}
			}
			if(firstQueue.isEmpty() && !secondQueue.isEmpty()){
				boolean isAllSame = true;
				String ch2 = secondQueue.poll();
				while(isAllSame && !secondQueue.isEmpty()){
					String ch3 = secondQueue.poll();
					if(firstQueue.isEmpty())
						firstQueue.offer(ch2);
					
					firstQueue.offer(ch3);
					if(!ch2.equals(ch3)){
						isAllSame = false;
						break;
					}
				}
				if(isAllSame){
					if(ch2.equals("D"))
						isRadiant = false;
					break;
				}
				while(!secondQueue.isEmpty()){
					String ch3 = secondQueue.poll();
					firstQueue.offer(ch3);
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