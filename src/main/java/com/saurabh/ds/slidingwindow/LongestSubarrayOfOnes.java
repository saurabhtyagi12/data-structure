package com.saurabh.ds.slidingwindow;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75

public class LongestSubarrayOfOnes {

    public int longestSubarray(int[] nums) {
        int max = 0;
		int n = nums.length;
		int index = -1;
		int temp = 0;
		for(int i=0; i < n; i++){
			if(nums[i] == 1) { 
				temp++;
			} else {
				if(index < 0){
					index = i;
				} else {
					if(temp > max)
						max = temp;
					temp = i - (index + 1);
					index = i;
				}
			}
				
		}
		if(temp > max)
			max = temp;
		if(index < 0)
			max--;
		return max;
    }
	
	public static void main(String[] args) {
		LongestSubarrayOfOnes lso = new LongestSubarrayOfOnes();
		System.out.println(lso.longestSubarray(new int[]{1,1,0,1}));
		System.out.println(lso.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
		System.out.println(lso.longestSubarray(new int[]{1,1,1}));
	}
}