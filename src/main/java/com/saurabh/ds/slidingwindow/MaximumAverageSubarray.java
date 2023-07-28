package com.saurabh.ds.slidingwindow;

// https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int win = k;
        if(n == 1)
            return (double)nums[0];

        int avg = 0;

        for(int i =0; i < k; i++) {
            avg += nums[i];
        }

        int prev = avg;
        for(int i =k; i < n; i++) {
            prev = prev + nums[i] - nums[i - k];
            if(prev > avg){
                avg = prev;
            }
        }

        return (avg/(1.0*k));
    }
	
	public static void main(String[] args){
		MaximumAverageSubarray mas = new MaximumAverageSubarray();
		int[] nums = {1,12,-5,-6,50,3};
		System.out.println(mas.findMaxAverage(nums, 4));
	}
}