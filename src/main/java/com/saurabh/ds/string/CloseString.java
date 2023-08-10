package com.saurabh.ds.string;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

// https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
class CloseString {
    public boolean closeStrings(String word1, String word2) {
		int w1l = word1.length();
		int w2l = word2.length();
		if(w1l != w2l)
			return false;
			
		int[] word1Arr = new int[26];
		int[] word2Arr = new int[26];

		int[] word1Char = new int[26];
		int[] word2Char = new int[26];

		for(int i = 0; i< w1l; i++){
			int ch1 = word1.charAt(i) - 'a';
			int cnt = word1Arr[ch1];
			word1Arr[ch1] = cnt + 1;
			word1Char[ch1] = 1;
				
			int ch2 = word2.charAt(i) - 'a';
			int cnt2 = word2Arr[ch2];
			word2Arr[ch2] = cnt2 + 1;
			word2Char[ch2] = 1;
		}
		
		for(int i = 0; i< 26; i++){
			if(word1Char[i] != word2Char[i])
				return false;
		}

		for(int i = 0; i< 26; i++){
			for(int j = i; j< 26; j++){
				if(word1Arr[i] < word1Arr[j]){
					int temp = word1Arr[i];
					word1Arr[i] = word1Arr[j];
					word1Arr[j] = temp;
				}
				if(word2Arr[i] < word2Arr[j]){
					int temp = word2Arr[i];
					word2Arr[i] = word2Arr[j];
					word2Arr[j] = temp;
				}
			}
			if(word1Arr[i] != word2Arr[i])
				return false;
			if(word1Arr[i] == 0 && word2Arr[i] == 0)			
				break;				
		}
		
		return true;
	}	
/*    public boolean closeStrings(String word1, String word2) {
      int w1l = word1.length();
			int w2l = word2.length();
			if(w1l != w2l)
				return false;
				
			Map<Integer, Integer> word1Map = new HashMap<>();
			Map<Integer, Integer> word2Map = new HashMap<>();
			for(int i = 0; i< w1l; i++){
				int ch1 = word1.charAt(i);
				Integer cnt1 = word1Map.get(ch1);
				if(cnt1 !=null)
					word1Map.put(ch1, (cnt1+1));
				else
					word1Map.put(ch1, 1);
					
				int ch2 = word2.charAt(i);
				Integer cnt2 = word2Map.get(ch2);
				if(cnt2 !=null)
					word2Map.put(ch2, (cnt2+1));
				else
					word2Map.put(ch2, 1);
				
			}
			
			if(word1Map.size() != word2Map.size())
				return false;

			List<Integer> lv1 = new ArrayList<>(word1Map.values());
			List<Integer> lv2 = new ArrayList<>(word2Map.values());
			lv1.sort(Comparator.naturalOrder());
			lv2.sort(Comparator.naturalOrder());

			List<Integer> lk1 = new ArrayList<>(word1Map.keySet());
			List<Integer> lk2 = new ArrayList<>(word2Map.keySet());
			lk1.sort(Comparator.naturalOrder());
			lk2.sort(Comparator.naturalOrder());

			if(lk1.equals(lk2) && lv1.equals(lv2))
				return true;
			
			return false;
    }
*/	
	public static void main(String[] args) {
		CloseString cs = new CloseString();
		String w1 = "axc";
		String w2 = "xac";
		System.out.println(w1 + " " + w2 + " :: " +cs.closeStrings(w1, w2));
		w1 = "axcc";
		w2 = "zzac";
		System.out.println(w1 + " " + w2 + " :: " +cs.closeStrings(w1, w2));
		w1 = "abbccc";
		w2 = "aabbcc";
		System.out.println(w1 + " " + w2 + " :: " +cs.closeStrings(w1, w2));
	}
}