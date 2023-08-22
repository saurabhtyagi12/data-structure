package com.saurabh.ds.stack;

// https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75
class RemoveStarFromString {
    public String removeStars(String s) {
		int lastCharIndex = -1;
		int n = s.length();
		char[] sb = new char[n];
		for(int i=0; i < n; i++){
			char ch = s.charAt(i);
			if(ch == '*') {
				lastCharIndex--;
			} else {
				lastCharIndex++;
				sb[lastCharIndex] = ch;
			}
		}		
		return lastCharIndex >= 0 ? String.copyValueOf(sb, 0, lastCharIndex + 1) : "";        
    }
	
	public static void main(String[] args) {
		RemoveStarFromString rsfs = new RemoveStarFromString();
		String str = "leet**cod*e";
		System.out.println(str + " : " + rsfs.removeStars(str));
		String str1 = "erase*****";
		System.out.println(str1 + " : " + rsfs.removeStars(str1));
		String str2 = "abb*cdfg*****x*";
		System.out.println(str2 + " : " + rsfs.removeStars(str2));
	}	
}