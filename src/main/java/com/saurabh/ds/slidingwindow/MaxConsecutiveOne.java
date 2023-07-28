package com.saurabh.ds.slidingwindow;

// https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75

class MaxConsecutiveOne {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 && (k >= 1 || nums[0] == 1))
            return 1;
        else if(n == 1)
            return 0;

        int temp = 0;
        int i=0, j=0;
        while(i<k && j<n){
            if(nums[j] == 0){
                i++;
            }
            temp++;
            j++;
        }

        int max = temp;
        while(j < n){
            if(nums[j] == 1){
                temp++;
            } else { // found 0
                if(temp > max)
                    max = temp;
                while(nums[j - temp] != 0){
                    temp--;
                }
            }

            j++;
        }
        if(temp > max)
            max = temp;
        return max;
    }
	
	public static void main(String[] args) {
		MaxConsecutiveOne mco = new MaxConsecutiveOne();
		
		System.out.println(mco.longestOnes(new int []{1,1,1,0,0,0,1,1,1,1,0}, 2));	
	}	
}