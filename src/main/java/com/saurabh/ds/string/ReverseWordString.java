package com.saurabh.ds.string;

// https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
class ReverseWordString {
    public String reverseWords(String s) {
        StringBuilder leftSb = new StringBuilder();
        StringBuilder rightSb = new StringBuilder();
        int leftIndex = -1;
        int leftLength = 0;
        int rightIndex = -1;
        int rightLength = 0;
        String leftWord = "";
        String rightWord = "";
        for(int i=0, j=s.length() -1; i <= j + 1; ) {
            if(s.charAt(i) == ' '){
                leftLength = i - leftIndex;
                if(leftIndex != -1 && leftLength > 0){
                    rightWord = s.substring(leftIndex, i);
                    if(rightWord.trim() != ""){
                        if(rightSb.length() == 0){
                            rightSb.insert(0, rightWord.trim());
                        } else {
                            rightSb.insert(0, rightWord.trim() + " ");
                        }
                    }
                }
                leftIndex = -1;
            } else if(leftIndex == -1 && s.charAt(i) != ' '){
                leftIndex = i;
            }
            
            if(s.charAt(j) == ' '){
                rightLength = rightIndex - j;
                if(rightIndex != -1 && rightLength > 0){
                    leftWord = s.substring(j + 1, rightIndex + 1);
                    if(leftWord.trim() != ""){
                        if(leftSb.length() == 0){
                            leftSb.append(leftWord.trim());
                        } else {
                            leftSb.append(" " + leftWord.trim());
                        }
                    }
                }
                rightIndex = -1;
            } else if(rightIndex == -1 && s.charAt(j) != ' '){
                rightIndex = j;
            }
            
            i++;
            j--;
        }

        if(leftIndex!= -1 && rightIndex != -1 && rightIndex + 1 - leftIndex > 0){
            leftWord = s.substring(leftIndex, rightIndex + 1);
            if(leftWord.trim() != ""){
                if(leftSb.length() == 0){
                    leftSb.append(leftWord.trim());
                } else {
                    leftSb.append(" " + leftWord.trim());
                }
            }

        }

        return (leftSb.toString() == "" ? "" : leftSb.toString() + " ") + rightSb.toString();
    }
	
	public static void main(String[] args){
		ReverseWordString rws = new ReverseWordString();
		String str = "the sky is blue";
		System.out.println(str);
		System.out.println(rws.reverseWords(str));
		str = "a good   example";
		System.out.println(str);
		System.out.println(rws.reverseWords(str));
		str = "  hello world  ";
		System.out.println(str);
		System.out.println(rws.reverseWords(str));
		str = "Alice does not even like bob";
		System.out.println(str);
		System.out.println(rws.reverseWords(str));
	}
}