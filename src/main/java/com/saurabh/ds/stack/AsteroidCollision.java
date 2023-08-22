package com.saurabh.ds.stack;

import java.util.Stack;
// https://leetcode.com/problems/asteroid-collision/?envType=study-plan-v2&envId=leetcode-75

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
		Stack<Integer> st = new Stack<>();
		st.push(asteroids[0]);
		for(int i=1; i < n; i++){
			if(st.isEmpty()){
				st.push(asteroids[i]);
			} else {		
				while(!st.isEmpty()){
					int top = st.peek();
					int el = asteroids[i];
					if(top < 0 && el < 0) {
						st.push(el);
						break;
					} else if(top > 0 && el > 0) {
						st.push(el);
						break;
					} else if(top < 0) {
						st.push(el);
						break;
					} else {
						int tmpt = top;
						int tmpel = el;
						if(top < 0) {
							tmpt = tmpt *-1;
						} else {
							tmpel = tmpel * -1;
						}
						
						if(tmpt == tmpel){
							st.pop();
							break;
						} else if(tmpt > tmpel) {
							break;
						} else {
							st.pop();
							if (st.isEmpty()){
								st.push(el);
								break;
							}
						}
					}
				}
			}
		}
		int index = st.size();
		int[] remArr = new int[index];
		while(!st.isEmpty()){
			index--;
			remArr[index] = st.pop();
		}
		return remArr;
    }
	
	public static void main(String[] args) {
		AsteroidCollision ac = new AsteroidCollision();
		int[] ast1 = {5,10,-5};
		print(ac.asteroidCollision(ast1));
		
		int[] ast2 = {8,-8};
		print(ac.asteroidCollision(ast2));

		int[] ast3 = {10,2,-5};
		print(ac.asteroidCollision(ast3));

		int[] ast4 = {-2, -1, 1, 2};
		print(ac.asteroidCollision(ast4));
	}
	
	public static void print(int[] arr){
		System.out.print("[");
		for(int i =0; i< arr.length; i++){
			System.out.print(arr[i]);
			if(i!=(arr.length -1))
				System.out.print(",");
		}
		System.out.println("]");
	}
}