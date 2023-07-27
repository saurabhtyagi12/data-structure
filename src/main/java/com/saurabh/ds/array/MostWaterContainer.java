package com.saurabh.ds.array;

// https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75

public class MostWaterContainer {
    public int maxArea(int[] height) {
		int n = height.length;
		if(n==2){
			return height[0] < height[1] ? height[0] : height[1];
		}
		
		int max = -1;
		
		for(int left = 0, right = n -1; left < right; ){
			int temp = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
			if(temp > max)
				max = temp;
			if(height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return max;			
    }
	
	public static void main(String[] args) {
		MostWaterContainer s = new MostWaterContainer();
		int[] arr = {1,8,6,2,5,4,8,3,7};
		System.out.println(s.maxArea(arr));
		int[] arr2 = {1,1};
		System.out.println(s.maxArea(arr2));
		int[] arr3 = {1,2,1};
		System.out.println(s.maxArea(arr3));
		int[] arr4 = {1,8,6,2,5,4,9,3,7};
		System.out.println(s.maxArea(arr4));
	}
}