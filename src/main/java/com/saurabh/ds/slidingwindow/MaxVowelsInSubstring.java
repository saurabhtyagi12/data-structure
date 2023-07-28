package com.saurabh.ds.slidingwindow;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75

class MaxVowelsInSubstring {
    public int maxVowels(String s, int k) {
        int max = 0;
		byte[] vowels = new byte['{'];
		vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = 1;
		
		for(int i=0; i<k; i++){
			char c = s.charAt(i);
			max = max + vowels[c];
		}

		int prev = max;
		for(int i=k; i<s.length(); i++){
			char c = s.charAt(i);
			prev = prev + vowels[c];
			c = s.charAt(i - k);
			prev = prev - vowels[c];
			if(prev > max)
				max = prev;
		}
		
		return max;
    }
	
	public static void main(String[] args) {
		MaxVowelsInSubstring mis = new MaxVowelsInSubstring();
		String s = "abciiidef";
		int k = 3;
		
		System.out.println(mis.maxVowels(s, k));	
	}
}