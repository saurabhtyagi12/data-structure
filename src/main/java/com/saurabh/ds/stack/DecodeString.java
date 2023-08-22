package com.saurabh.ds.stack;

import java.util.Stack;
import java.util.stream.Collectors;

// https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75
public class DecodeString {

    public String decodeString(String s) {
    	String decodedString = "";
        String[] elements = new String[105]; // max result can be of this length as per requirement
        int cnt = 0;
        for(int i = 0; i< s.length(); i++) {
        	if(s.charAt(i) != ']') {
        		elements[cnt] = String.valueOf(s.charAt(i));
				cnt++;
        	}
        	
        	if(s.charAt(i) == ']') {
        		String tempStr = "";
				cnt--;
        		while(cnt > 0 && !elements[cnt].equals("[")) {
        			tempStr = elements[cnt] + tempStr;
					cnt--;
        		}
        		
    			cnt--;
        		if(cnt > -1 ) {
        			String counter = "";
            		while(cnt > -1 && Character.isDigit(elements[cnt].charAt(0))) {
            			counter = elements[cnt] + counter;
						cnt--;
            		}
            		
            		int counterNumber = Integer.parseInt(counter);
            		String tempDecodedStr = "";
            		for(int j =0; j< counterNumber; j++) {
            			tempDecodedStr = tempDecodedStr + tempStr;
            		}
            		
					cnt++;
            		elements[cnt] = tempDecodedStr;
					cnt++;
        		}
        	}
        }    	
    	
		
		// while(!elements.isEmpty()) { decodedString = elements.pop() + decodedString;
		// }
	
		for(int i =0; i < cnt; i++){
			decodedString = decodedString + elements[i];
		}
        
//        return elements.stream().map(a -> a.toString()).collect(Collectors.joining(""));
    	return decodedString;
    }

/* // using stack
    public String decodeString(String s) {
    	String decodedString = "";
        Stack<String> elements = new Stack<String>();
        
        for(int i = 0; i< s.length(); i++) {
        	if(s.charAt(i) != ']') {
        		elements.push(String.valueOf(s.charAt(i)));
        	}
        	
        	if(s.charAt(i) == ']') {
        		String tempStr = "";
        		while(!elements.isEmpty() && !elements.peek().equals("[")) {
        			tempStr = elements.pop() + tempStr;
        		}
        		
    			elements.pop();
        		if(!elements.isEmpty()) {
        			String counter = "";
            		while(!elements.isEmpty() && Character.isDigit(elements.peek().charAt(0))) {
            			counter = elements.pop() + counter;
            		}
            		
            		int counterNumber = Integer.parseInt(counter);
            		String tempDecodedStr = "";
            		for(int j =0; j< counterNumber; j++) {
            			tempDecodedStr = tempDecodedStr + tempStr;
            		}
            		
            		elements.push(tempDecodedStr);
        		}
        	}
        }    	
    	
		
		// while(!elements.isEmpty()) { decodedString = elements.pop() + decodedString;
		// }
		
        
        return elements.stream().map(a -> a.toString()).collect(Collectors.joining(""));
//    	return decodedString;
    }
  */  
	
	public static void main(String[] args) {
		DecodeString descodeString = new DecodeString();
		System.out.println("3[a]2[bc] :: " + descodeString.decodeString("3[a]2[bc]"));
		System.out.println("3[a2[bc]] :: " + descodeString.decodeString("3[a2[bc]]"));
		System.out.println("3[a]2[bc]2[xy] :: " + descodeString.decodeString("3[a]2[bc]2[xy]"));
	}
}
