package com.saurabh.ds.string;

import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
public class KidWithMaxCandies{

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> maxCandies = new ArrayList<Boolean>();
		int max = 0;
		int cnt = 0;
		while(cnt < candies.length){
			if(max < candies[cnt])
				max = candies[cnt];
			cnt++;
		}
		
		cnt = 0;
		while(cnt < candies.length){
			if(max <= (candies[cnt] + extraCandies))
				maxCandies.add(true);
			else
				maxCandies.add(false);
			cnt++;
		}
		
		return maxCandies;
	}
	
	public static void main(String[] args){
		int[] candies = {2,3,5,1,3};
		KidWithMaxCandies kwmc = new KidWithMaxCandies();
		System.out.println(kwmc.kidsWithCandies(candies, 3));
	}
}