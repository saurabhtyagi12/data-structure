package com.saurabh.ds.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class DecodeString {

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
    	
		/*
		 * while(!elements.isEmpty()) { decodedString = elements.pop() + decodedString;
		 * }
		 */
        
        return elements.stream().map(a -> a.toString()).collect(Collectors.joining(""));
//    	return decodedString;
    }
    
	public static void main(String[] args) {
		DecodeString descodeString = new DecodeString();
		System.out.println(descodeString.decodeString("3[a]2[bc]"));
		System.out.println(descodeString.decodeString("3[a2[bc]]"));
		System.out.println(descodeString.decodeString("3[a]2[bc]2[xy]"));
	}
}
