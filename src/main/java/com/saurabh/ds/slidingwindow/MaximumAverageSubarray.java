package com.saurabh.ds.slidingwindow;

// https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int win = k;
        if(n == 1)
            return (double)nums[0];

        double avg = 0;
        double prev = 0;
        for(int i =0; i < n; i++) {
            if(win == 0){
                double temp = prev + nums[i] - nums[i - k];
                if(temp > avg){
                    avg = temp;
                }
                prev = temp;
            } else {
                prev += nums[i];
                win--;
                avg = prev;
            }

        }

        return (avg/k);
    }
	
	public static void main(String[] args){
		MaximumAverageSubarray mas = new MaximumAverageSubarray();
		int[] nums = {1,12,-5,-6,50,3};
		System.out.println(mas.findMaxAverage(nums, 4));
	}
}