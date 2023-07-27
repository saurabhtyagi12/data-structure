package com.saurabh.ds.string;

// https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75

class ArrayCompression {
    public int compress(char[] chars) {
		print(chars);
			int cnt = 1;
			char currentChar = chars[0];
			int index = 0;
			for(int i=1; i< chars.length; i++) {
				if(currentChar != chars[i]){
					chars[index] = currentChar;
					index++;
					if(cnt > 9 ){
						String str = new String(cnt+"");
						for(char ch : str.toCharArray()){
							chars[index] = ch;
							index++;
						}
					} else if(cnt >1){
							chars[index] = (char)(cnt + '0');
							index++;
					}
					currentChar = chars[i];
					cnt = 1;
				} else {
					cnt++;
				}
			}		
			
			chars[index] = currentChar;
			index++;
			if(cnt > 9 ){
				String str = new String(cnt+"");
				for(char ch : str.toCharArray()){
					chars[index] = ch;
					index++;
				}
			} else if(cnt >1){
					chars[index] = (char)(cnt + '0');
					index++;
			}

		print(chars);
		return index;        
    }
	
	public void print(char[] chars){
		System.out.print("[");
		for(int i=0; i< chars.length; i++) {
			System.out.print(chars[i] + ",");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		ArrayCompression ac = new ArrayCompression();
		char[] chars = {'a','a','b','b','c','c','c'};
		System.out.println(ac.compress(chars));
		char[] chars2 = {'a'};
		System.out.println(ac.compress(chars2));
		char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println(ac.compress(chars3));
	}
}