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
				int lpair = k - lval;
				Integer lpairFromMap = pair.remove(lpair);
				if(lpairFromMap !=null){
					cnt++;
					lpairFromMap--;
					if(lpairFromMap > 0){
						pair.put(lpair, lpairFromMap);
					}
				} else {
					Integer lvalFromMap = pair.get(lval);
					if(lvalFromMap !=null) {
						pair.put(lval, lvalFromMap + 1);
					} else {
						pair.put(lval, 1);
					}
				}

				int rpair = k - rval;
				Integer rpairFromMap = pair.remove(rpair);
				if(rpairFromMap !=null){
					cnt++;
					rpairFromMap--;
					if(rpairFromMap > 0){
						pair.put(rpair, rpairFromMap);
					}
				} else {
					Integer rvalFromMap = pair.get(rval);
					if(rvalFromMap !=null) {
						pair.put(rval, rvalFromMap + 1);
					} else {
						pair.put(rval, 1);
					}
				}
			}
			i++;
			j--;
		}
		
		if(i == j && i == (nums.length/2)){
			int lval = nums[i];
			int lpair = k - lval;
			Integer lpairFromMap = pair.remove(lpair);
			if(lpairFromMap !=null){
				cnt++;
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