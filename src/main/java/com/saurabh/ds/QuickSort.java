package com.saurabh.ds;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class QuickSort {

	public static void main(String[] args) {
		int[] data = populateDataToSort(10);
		printData("Data before sorting ...", data);

		quicksort(data, 0, data.length-1);
		printData("Sorted Data ...", data);
	}

	private static void quicksort(int[] data, int left, int right) {
		if(left >= right)
			return;
		
		int pivot = data[(left + right)/2];
		int index = partition(data, left, right, pivot);
		quicksort(data, left, index-1);
		quicksort(data, index, right);
	}

	private static int partition(int[] data, int left, int right, int pivot) {
		while(left <= right) {
			while(data[left] < pivot) {
				left++;
			}
			
			while (data[right] > pivot) {
				right--;				
			}
			
			if(left <= right) {
				swap(data, left, right);
				left++;
				right--;
			}
			
		}
		return left;
	}

	private static void swap(int[] data, int left, int right) {
		int temp = data[left];
		data[left] = data[right];
		data[right] = temp;
		
	}

	private static void printData(String message, int[] data) {
		System.out.println(message);
		IntStream dataStream = Arrays.stream(data);
		
		dataStream.forEach(item -> System.out.print(item +", "));
		System.out.println("");
		
	}

	private static int[] populateDataToSort(int length) {
		int[] data = new int[length];
		Random random = new Random();
		for(int i=0; i < length; i++) {
			data[i] = (int) random.nextInt(1000);
		}
		return data;
	}

}
