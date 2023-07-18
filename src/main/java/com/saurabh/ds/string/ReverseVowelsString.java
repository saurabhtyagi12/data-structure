package com.saurabh.ds.string;

// https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
public class ReverseVowelsString {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);

        int leftIndex = -1;
        int rightIndex = -1;

        for(int i=0, j=s.length() -1; i < j; ){
            if(leftIndex == -1) {
                char leftChar = s.charAt(i);
                if(leftChar == 'a' || leftChar == 'e' || leftChar == 'i' || leftChar == 'o' || leftChar == 'u' || leftChar == 'A' || leftChar == 'E' || leftChar == 'I' || leftChar == 'O' || leftChar == 'U'){
                    leftIndex = i;                
                }
            }

            if(rightIndex == -1) {
                char rightChar = s.charAt(j);
                if(rightChar == 'a' || rightChar == 'e' || rightChar == 'i' || rightChar == 'o' || rightChar == 'u' || rightChar == 'A' || rightChar == 'E' || rightChar == 'I' || rightChar == 'O' || rightChar == 'U'){
                    rightIndex = j;
                }
            }

            if(leftIndex != -1 && rightIndex != -1){
                char leftChar = s.charAt(leftIndex);
                sb.setCharAt(leftIndex, s.charAt(rightIndex));
                sb.setCharAt(rightIndex, leftChar);
                leftIndex = -1;
                rightIndex = -1;
            }

            if(leftIndex == -1){
                i++;
            }
            if(rightIndex == -1){
                j--;
            }
        }
        return sb.toString();
    }
	
	public static void main(String args[]) {
		ReverseVowelsString rvs = new ReverseVowelsString();
		System.out.println(rvs.reverseVowels("Hello"));
	}
}