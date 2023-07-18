package com.saurabh.ds.string;

// https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] arr) {
        int[] arrleft = new int[arr.length];
        arrleft[0] = 1;
        arrleft[arr.length-1] = 1;
        int lefttemp = 1;
        int righttemp = 1;
        int left =1, right=arr.length-2;
        for(; left < right; left++, right--){            
            lefttemp = lefttemp * arr[left - 1];
            righttemp = righttemp * arr[right + 1];
            arrleft[left] = lefttemp;
            arrleft[right] = righttemp;
        }
        if(left == right){
            lefttemp = lefttemp * arr[left - 1];
            righttemp = righttemp * arr[right + 1];
            arrleft[left] = lefttemp * righttemp; 
            left++;
            right--;
        }
        for(; left < arr.length; left++, right--){            
            lefttemp = lefttemp * arr[left - 1];
            righttemp = righttemp * arr[right + 1];
            arrleft[left] = lefttemp * arrleft[left];
            arrleft[right] = righttemp * arrleft[right];		
        }
        return arrleft;
    }
	
	public static void main(String[] args) {
		ProductOfArrayExceptSelf paes = new ProductOfArrayExceptSelf();
		int[] arr = {1, 2, 3, 4};
		for(int i=0; i< arr.length; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.println(" ");
		int[] prodarr = paes.productExceptSelf(arr);
		for(int i=0; i< prodarr.length; i++){
			System.out.print(prodarr[i] + ", ");
		}
		System.out.println(" ");
		int[] arr2 = {1,2,3,4,5};
		for(int i=0; i< arr2.length; i++){
			System.out.print(arr2[i] + ", ");
		}
		System.out.println(" ");
		int[] prodarr2 = paes.productExceptSelf(arr2);
		for(int i=0; i< prodarr2.length; i++){
			System.out.print(prodarr2[i] + ", ");
		}
		System.out.println(" ");
	}
	
}