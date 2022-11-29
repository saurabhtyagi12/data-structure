package com.saurabh.ds;

import java.util.HashSet;
import java.util.Set;

public class StringCombination {

	public static void main(String[] args) {
		String str = "ABC";
		System.out.println("Getting combinations for -> " + str);
		Set<String> strCombination = getStringCombinationSet(str);

		print(strCombination);
	}

	private static void print(Set<String> strCombination) {
		System.out.println("Total combinations -> " + strCombination.size());
		strCombination.stream().forEach(item -> System.out.print(item + ", "));

	}

	private static Set<String> getStringCombinationSet(String str) {
		Set<String> strCombination = new HashSet<String>();
		if (str.length() == 1) {
			strCombination.add(str);
			return strCombination;
		}
		for (int j = 0; j < str.length(); j++) {
			char firstChar = str.charAt(j);
			Set<String> strSubStringCombination = getStringCombinationSet(str.substring(0, j) + str.substring(j+1));

//			print("Sub strings set", strSubStringCombination);
			insertCharToSetStrings(firstChar, strSubStringCombination, strCombination);

		}
		return strCombination;
	}

	private static void insertCharToSetStrings(char firstChar, Set<String> strSubStringCombination,
			Set<String> strCombination) {
		for (String subString : strSubStringCombination) {
			for (int i = 0; i < subString.length(); i++) {
				String finalStr = subString.substring(0, i) + firstChar + subString.substring(i);
				strCombination.add(finalStr);
			}

		}
	}

	private static void print(String message, Set<String> strSubStringCombination) {
		System.out.println(message);
		print(strSubStringCombination);
	}
}
