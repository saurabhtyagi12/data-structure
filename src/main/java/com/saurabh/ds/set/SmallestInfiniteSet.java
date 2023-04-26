package com.saurabh.ds.set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/smallest-number-in-infinite-set/description/
public class SmallestInfiniteSet {

	ArrayList<Integer> numbers = new ArrayList<Integer>();
    public SmallestInfiniteSet() {
        for(int i =1000; i>0; i--){
            numbers.add(i);
        }
    }
    
    public int popSmallest() {
    	if(numbers.size() == 0)
    		return 0;
        return numbers.remove(numbers.size() - 1);
    }
    
    public void addBack(int num) {
    	int index = 0;
        for (int item : numbers) {
			if(num > item)
				break;
			if(num == item)
				return;
			index++;
		} 
        
        numbers.add(index, num);
        
    }
    
    public static void main(String[] args) {
    	SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
    	smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
    	System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 is the smallest number, and remove it from the set.
    	System.out.println(smallestInfiniteSet.popSmallest()); // return 2, and remove it from the set.
    	System.out.println(smallestInfiniteSet.popSmallest()); // return 3, and remove it from the set.
    	smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
    	System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 was added back to the set and
    	                                   // is the smallest number, and remove it from the set.
    	System.out.println(smallestInfiniteSet.popSmallest()); // return 4, and remove it from the set.
    	System.out.println(smallestInfiniteSet.popSmallest()); // return 5, and remove it from the set.
	}
}
