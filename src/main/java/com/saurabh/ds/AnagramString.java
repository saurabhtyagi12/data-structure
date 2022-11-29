package com.saurabh.ds;

import java.util.Arrays;

public class AnagramString {

	public static void main(String[] args) {
		String str1 = "Race";
		String str2 = "Care";

		boolean isStringAnagram = isStringAnagram(str1, str2);
		if (isStringAnagram) {
			System.out.println(str1 + ", " + str2 + " are Anagram string ....");
		} else {
			System.out.println(str1 + ", " + str2 + " are NOT Anagram string ....");
		}

		String str3 = "Race";
		String str4 = "Carw";
		isStringAnagram = isStringAnagram(str3, str4);
		if (isStringAnagram) {
			System.out.println(str3 + ", " + str4 + " are Anagram string ....");
		} else {
			System.out.println(str3 + ", " + str4 + " are NOT Anagram string ....");
		}
	}

	private static boolean isStringAnagram(String str1, String str2) {
		char[] str1CharArr = getSortedArray(str1);
		char[] str2CharArr = getSortedArray(str2);
//		print("str1 ===", str1CharArr);
//		print("str2 ===", str2CharArr);
		return Arrays.equals(str1CharArr, str2CharArr);

	}

	private static char[] getSortedArray(String str) {
		char[] strCharArr = str.toLowerCase().toCharArray();
//		print("str ===", strCharArr);
		char[] sortedArr = new char[str.length()];
		sortArray(strCharArr, sortedArr);
		return sortedArr;
	}

	private static void sortArray(char[] srcArr, char[] destArr) {
		if (srcArr.length < 2) {
			destArr[0] = srcArr[0];
			return;
		}

//		print("srcArr === ", srcArr);
		int midpoint = srcArr.length / 2;
		char[] leftArr = new char[midpoint];
		char[] rightArr = new char[srcArr.length - midpoint];

		copyArray(srcArr, 0, midpoint, leftArr);
		copyArray(srcArr, midpoint, srcArr.length, rightArr);

		char[] leftSortedArr = new char[midpoint];
		char[] rightSortedArr = new char[srcArr.length - midpoint];
		sortArray(leftArr, leftSortedArr);
		sortArray(rightArr, rightSortedArr);

//		print("leftArr  === ", leftArr);
//		print("rightArr === ", rightArr);
//		print("destArr  === ", destArr);
		merge(leftSortedArr, rightSortedArr, destArr);
//		print("destArr  === ", destArr);
	}

	private static void print(String message, char[] leftArr) {
		System.out.print(message + "[");
		for (char c : leftArr) {
			System.out.print(c + ",");
		}
		System.out.println("]");
	}

	private static void copyArray(char[] srcArr, int startIndex, int endpoint, char[] destArr) {
		for (int i = 0; i < endpoint - startIndex; i++) {
			destArr[i] = srcArr[i + startIndex];
		}
	}

	private static void merge(char[] leftArr, char[] rightArr, char[] destArr) {
		int i = 0, j = 0, index = 0;
//		System.out.println("destArr = " + destArr.length);

		while (i < leftArr.length && j < rightArr.length) {
//			System.out.println("i=" +i+", j="+j +", index=" + index);
			if (leftArr[i] <= rightArr[j]) {
				destArr[index] = leftArr[i];
				i++;
			} else {
				destArr[index] = rightArr[j];
				j++;
			}
			index++;
		}

		while (i < leftArr.length) {
			destArr[index] = leftArr[i];
			i++;
			index++;
		}

		while (j < rightArr.length) {
			destArr[index] = rightArr[j];
			j++;
			index++;
		}

	}
}
