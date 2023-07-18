package com.saurabh.ds;

// https://leetcode.com/problems/add-digits/
public class AddDigits {

    public int addDigits(int num) {
        if(num < 10)
        	return num;
    	int sum = 0;
    	while(num > 9) {
    		sum = sum + (num%10);
    		num = num / 10;
    	}
		sum = sum + num;
    	return addDigits(sum);
    }
    
    public static void main(String[] args) {
		AddDigits digits = new AddDigits();
		System.out.println(digits.addDigits(12456));
	}
}
