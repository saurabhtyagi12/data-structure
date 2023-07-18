package com.saurabh.ds.string;

import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if(str1 == null || str2 == null || "".equals(str1) || "".equals(str2))
        	return "";
        
        String smallStr = "";
        String bigStr = "";
        
        if(str1.length() < str2.length()){
            smallStr = str1;
            bigStr = str2;
        }else {
            smallStr = str2;
            bigStr = str1;
        }

		int smallStrLength = smallStr.length();
		int bigStrLength = bigStr.length();

        if((bigStrLength % smallStrLength == 0) && checkStringDivides(smallStr, bigStr, smallStr, smallStrLength))
            return smallStr;
		
		int mid = smallStrLength/2;
		int cnt = 2;
        int largestStrLength = 0;
		Map<Integer, Integer> gcds = new HashMap<Integer, Integer>();
		
		while(cnt <= mid){
			if(largestStrLength < cnt && gcds.get(cnt) == null && (smallStrLength % cnt == 0) && (bigStrLength % cnt == 0)){
				Integer gcd = (smallStrLength / cnt); 
				if(largestStrLength < gcd && gcds.get(gcd) == null && (smallStrLength % gcd == 0) && (bigStrLength % gcd == 0)){
					if(checkStringDivides(smallStr, bigStr, smallStr.substring(0, gcd), gcd)){
						largestStrLength = gcd;
					}
					gcds.put(gcd, gcd);
				}
				
				if(checkStringDivides(smallStr, bigStr, smallStr.substring(0, cnt), cnt)){
					largestStrLength = cnt;
				}
				
				gcds.put(cnt, cnt);
			}
			cnt++;
		}
		
        return smallStr.substring(0, largestStrLength);
    }

    public boolean checkStringDivides(String smallStr, String bigStr, String gcd, int gcdLength){
        int currIndex = 0;
        while(currIndex + gcdLength <= smallStr.length()){
            if(!smallStr.substring(currIndex, currIndex + gcdLength).equals(gcd))
                return false;
            if(!bigStr.substring(currIndex, currIndex + gcdLength).equals(gcd))
                return false;
            currIndex = currIndex + gcdLength;
            if(currIndex == smallStr.length())
                break;
        }
        
        if(currIndex == smallStr.length() && currIndex == bigStr.length()){
            return true;
        } else  if(currIndex == smallStr.length()){
            while(currIndex + gcdLength <= bigStr.length()){
                if(!bigStr.substring(currIndex, currIndex + gcdLength).equals(gcd))
                    return false;
                currIndex = currIndex + gcdLength;
                if(currIndex == bigStr.length())
                    return true;
            }
        }

        return false;
    }
     
	public static void main(String[] args){
		GcdOfStrings gcds = new GcdOfStrings();
		System.out.println(gcds.gcdOfStrings("ABABAB", "ABAB"));
	}
}