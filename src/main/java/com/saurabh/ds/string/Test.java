package com.saurabh.ds.string;

import reactor.util.StringUtils;

public class Test {

	public static void main(String[] args) {
		String str = "00FA08000101F2645A651F;encoding=hex";
//		str="ABC;encoding=hex";
		int li = str.lastIndexOf(";encoding=hex");
		System.out.println(li);
		if(li>0)
		System.out.println((new Test()).removeHexEncoding(str));
		System.out.println((new Test()).removeHexEncoding("abc"));
		System.out.println("DONE 1");
		System.out.println((new Test()).deleteString(str, ";encoding=hex"));
		System.out.println((new Test()).deleteString("abc", ";encoding=hex"));
		System.out.println((new Test()).deleteString("", ";encoding=hex"));
		System.out.println((new Test()).deleteString("   ", ";encoding=hex"));
		System.out.println((new Test()).deleteString(null, ";encoding=hex"));
		System.out.println("DONE 2...");
	}
	
	private String removeHexEncoding(final String inStr) {
		if(inStr != null && !"".equals(inStr.trim())) {
			int li = inStr.lastIndexOf(";encoding=hex");
			if(li>0)
				return inStr.substring(0, li);
			else
				return inStr;
		}
		return "";
	}
	
	private String deleteString(String inStr, String hexEncodingStr) {
		return StringUtils.delete(inStr, hexEncodingStr);
	}
}
