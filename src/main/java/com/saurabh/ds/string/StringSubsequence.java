package com.saurabh.ds.string;

class StringSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() ==0)
			return true;
		if(t.length() ==0)
			return false;
		char ch = s.charAt(0);
		for(int i=0, j=0; i<t.length() && j<s.length(); i++){
			if(t.charAt(i) == ch){
				j++;
				if(j == s.length())
					return true;
				ch = s.charAt(j);
			}
		}

		return false;
    }
	
	public static void main(String[] args){
		StringSubsequence ss = new StringSubsequence();
		System.out.println(ss.isSubsequence("ab", "acb"));
		System.out.println(ss.isSubsequence("ax", "abc"));
		
	}
}