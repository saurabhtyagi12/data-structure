package com.saurabh.ds.string;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/
public class GreatestCommonDivisorString {

    public String gcdOfStrings(String str1, String str2) {
        if(str1 == null || str2 == null || "".equals(str1) || "".equals(str2))
        	return "";
        
        if(str1.equals(str2))
        	return str1;
        
        if(str1.charAt(0) == str2.charAt(0)) {
        	return str1.charAt(0) + gcdOfStrings(str1.substring(1), str2.substring(1));
        } else {
        	String firstStr = gcdOfStrings(str1.substring(1), str2);
        	String secondStr = gcdOfStrings(str1, str2.substring(1));
        	return firstStr.length() > secondStr.length() ? firstStr : secondStr;
        }
    }
    
    public static void main(String[] args) {
		GreatestCommonDivisorString gcds = new GreatestCommonDivisorString();
		String str1 = "DABCABC";
		String str2 = "PABD";
		
		System.out.println(str1 + ", " + str2 + " ==>>> " + gcds.gcdOfStrings(str1, str2));

		str1 = "ABCABC";
		str2 = "ABC";
		
		System.out.println(str1 + ", " + str2 + " ==>>> " + gcds.gcdOfStrings(str1, str2));

		str1 = "ABABAB";
		str2 = "ABAB";
		
		System.out.println(str1 + ", " + str2 + " ==>>> " + gcds.gcdOfStrings(str1, str2));

		str1 = "LEET";
		str2 = "CODE";
		
		System.out.println(str1 + ", " + str2 + " ==>>> " + gcds.gcdOfStrings(str1, str2));

    }
}
