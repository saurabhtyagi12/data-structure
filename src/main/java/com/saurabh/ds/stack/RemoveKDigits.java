package com.saurabh.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        String finalDigits = "";
        Stack<String> digits = new Stack<String>();
        
        int totalDigits = num.length();
        int numDigits = totalDigits - k;
        if(numDigits == 0)
        	return "0";
        
        for(int i=0; i < totalDigits && numDigits > digits.size(); i++) {
        	// get endIndex by leaving the remaining_digits - 1
        	int endIndex = totalDigits - (numDigits - digits.size() -1);
        	i = getMinimumDigitIndexFromSubString(num, i, endIndex );
        	digits.push(String.valueOf(num.charAt(i)));        	
        }
        
        if(digits.empty()) {
        	return "0";
        }
        
        String tempZeros = "";
        while (!digits.isEmpty()) {
        	String digit = digits.pop();
        	if(digit.equals("0")) {
        		tempZeros = tempZeros + digit;
        	} else {
        		finalDigits = digit + tempZeros + finalDigits;
        		tempZeros = "";
        	}
		}
        
        if(finalDigits.isEmpty())
        	return "0";
        
        return finalDigits;
    }
    
	private int getMinimumDigitIndexFromSubString(String num, int i, int j) {
		int minDigit = Integer.MAX_VALUE;
		int minIndex = i;
		for(int cnt = i; cnt < j; cnt++) {
			int temp = Integer.parseInt(String.valueOf(num.charAt(cnt)));
			if(minDigit > temp) {
				minDigit = temp;
				minIndex = cnt;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		RemoveKDigits digits = new RemoveKDigits();
		System.out.println(digits.removeKdigits("1432219", 3));
		System.out.println(digits.removeKdigits("10200", 1));
		System.out.println(digits.removeKdigits("10", 2));
		System.out.println(digits.removeKdigits("112", 1));
	}
}
