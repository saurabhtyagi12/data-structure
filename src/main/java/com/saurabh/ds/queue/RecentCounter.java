package com.saurabh.ds.queue;

import java.util.Queue;
import java.util.ArrayDeque;

// https://leetcode.com/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75

public class RecentCounter {
	Queue<Integer> requests = null;
	public RecentCounter() {
        requests = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        requests.offer(t);
		int range = (t - 3000);
		int top = requests.peek();
		while(top < range) {
			requests.poll();
			top = requests.peek();
		}
		return requests.size();
    }

	public static void main(String[] args){
		RecentCounter recentCounter = new RecentCounter();
		System.out.println(recentCounter.ping(1));
		System.out.println(recentCounter.ping(100));
		System.out.println(recentCounter.ping(3001));
		System.out.println(recentCounter.ping(3002));
	}
}