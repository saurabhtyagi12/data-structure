package com.saurabh.ds.string;

class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int firstIndex = 0;
        int secondIndex = -1;
		int tempSmallNumberIndex = 0;
        for(int i=1; i < nums.length; i++){
            if(nums[firstIndex] < nums[i]){
                if(secondIndex > -1 && nums[secondIndex] < nums[i]) { // found 3 sequence
                    return true;
                } else {
                    secondIndex = i;
                }
            } else if(secondIndex < 0 ) { 
				firstIndex = i;
				tempSmallNumberIndex = i;
            } else if(secondIndex > -1) { 
				if(nums[tempSmallNumberIndex] < nums[i]){			
					firstIndex = tempSmallNumberIndex;
					secondIndex = i;
				} else {
					tempSmallNumberIndex = i;
				}
            }
        }
        return false;
    }

	public static void main(String[] args) {
		IncreasingTriplet it = new IncreasingTriplet();
		int[] nums = {20,100,10,12,5,13};
		System.out.println(it.increasingTriplet(nums));
	}
}