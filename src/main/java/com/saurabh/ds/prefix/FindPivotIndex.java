package com.saurabh.ds.prefix;

// https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75

class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
		leftSum[0] = 0;
		rightSum[n - 1] = 0;
		
        for(int i = 1; i < n ; i++) {
			leftSum[i] = leftSum[i - 1] + nums[i - 1];
			rightSum[n - i - 1] = rightSum[n - i] + nums[n - i];
        }
		
        for(int i = 0; i < n ; i++) {
			if(leftSum[i] == rightSum[i])
				return i;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		FindPivotIndex fpi = new FindPivotIndex();
		System.out.println("[1,7,3,6,5,6] :: " + fpi.pivotIndex(new int[] {1,7,3,6,5,6}));
		System.out.println("[1,2,3] :: " + fpi.pivotIndex(new int[] {1,2,3}));
		System.out.println("[-1,-1,-1,-1,-1,0] :: " + fpi.pivotIndex(new int[] {-1,-1,-1,-1,-1,0}));
		System.out.println("[-1,-1,-1,-1,0,1] :: " + fpi.pivotIndex(new int[] {-1,-1,-1,-1,0,1}));
		System.out.println("[-1,-1,-1,0,1,1] :: " + fpi.pivotIndex(new int[] {-1,-1,-1,0,1,1}));
	}
}