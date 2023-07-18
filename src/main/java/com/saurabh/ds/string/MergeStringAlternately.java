package com.saurabh.ds.string;

// https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
public class MergeStringAlternately {
    public String mergeAlternately(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        if(word1Len == 0)
            return word2;

        if(word2Len == 0)
            return word1;
            
        StringBuilder mergedWord = new StringBuilder("");
        int i=0;
        while(i < word1Len && i < word2Len ){
            mergedWord.append(word1.charAt(i));
            mergedWord.append(word2.charAt(i));
            i++;
        }

        if(i < word1Len){
            mergedWord.append(word1.substring(i));
        }

        if(i < word2Len){
            mergedWord.append(word2.substring(i));
        }

        return mergedWord.toString();
    }
	
	public static void main(String[] args) {
		MergeStringAlternately msa = new MergeStringAlternately();
		System.out.println(msa.mergeAlternately("ab", "pqrs"));
	}
}