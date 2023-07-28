package com.saurabh.ds.array;

import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75

public class MaxOperationOnArray {

    public int maxOperations(int[] nums, int k) {
        int cnt = 0;
		Map<Integer, Integer> pair = new HashMap<Integer, Integer>();
		if(nums.length == 1 || k == 1)
			return cnt;
		int i=0;
		int j=nums.length - 1;
		while(i <j){
			int lval = nums[i];
			int rval = nums[j];
			if(lval + rval == k){
				cnt++;
			} else {
				if(lval < k){
					cnt = updateCount(cnt, lval, pair, k);
				}
				
				if(rval < k) {
					cnt = updateCount(cnt, rval, pair, k);
				}
			}
			i++;
			j--;
		}
		
		if(i == j && i == (nums.length/2)){
			int lval = nums[i];
			int lpair = k - lval;
			Integer lpairFromMap = pair.get(lpair);
			if(lpairFromMap !=null && lpairFromMap > 0){
				cnt++;
			} 
		}
		return cnt;
    }
	
	private int updateCount(int cnt, int lval, Map<Integer, Integer> pair, int k) {
		int lpair = k - lval;
		Integer lpairFromMap = pair.get(lpair);
		if(lpairFromMap !=null && lpairFromMap > 0){
			cnt++;
			lpairFromMap--;
			pair.put(lpair, lpairFromMap);
		} else {
			Integer lvalFromMap = pair.get(lval);
			if(lvalFromMap !=null) {
				pair.put(lval, lvalFromMap + 1);
			} else {
				pair.put(lval, 1);
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		MaxOperationOnArray moa = new MaxOperationOnArray();

		int[] nums = {1,2,3,4};
		int k = 5;
		System.out.println(moa.maxOperations(nums, k));

		int[] nums2 = {3,1,3,4,3};
		k = 6;
		System.out.println(moa.maxOperations(nums, k));
	}
}