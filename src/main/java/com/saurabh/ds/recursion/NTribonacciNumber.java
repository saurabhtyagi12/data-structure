package com.saurabh.ds.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-th-tribonacci-number/description/
public class NTribonacciNumber {

	List<Integer> tribonacciNumbers;

	public int tribonacci(int n) {
		if (n <= 0) {
			tribonacciNumbers = new ArrayList<Integer>();
			tribonacciNumbers.add(0);
			return 0;
		} else if (n == 1) {
			tribonacci(n - 1);
			tribonacciNumbers.add(1);
		} else {
			tribonacci(n - 1);
			int sum = 0;
			for (int i = n - 1; i >= n - 3 && i > 0; i--) {
				sum = sum + tribonacciNumbers.get(i);
			}
			tribonacciNumbers.add(sum);
		}

		return tribonacciNumbers.get(n);
	}

	public static void main(String[] args) {
		NTribonacciNumber ntn = new NTribonacciNumber();
		int n = 0;
		System.out.println(n + "= " + ntn.tribonacci(n));
		n = 1;
		System.out.println(n + "= " + ntn.tribonacci(n));
		n = 2;
		System.out.println(n + "= " + ntn.tribonacci(n));
		n = 3;
		System.out.println(n + "= " + ntn.tribonacci(n));
		n = 25;
		System.out.println(n + "= " + ntn.tribonacci(n));
	}
}
