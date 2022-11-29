package com.saurabh.ds;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.kafka.common.protocol.Message;

public class MergeSort {

	public static void main(String[] args) {
		int[] data = populateDataToSort(1000);
		// 41, 221, 232, 960, 956, 727, 331, 394, 867, 454,
//		int[] data = {41, 221, 232, 960, 956, 727, 331, 394, 867, 454};
//		int[] data = {43, 488, 894, 665, 502, 927, 869, 330, 699, 149};
		printData("Data before sorting ...", data);
		// merge sort with single array
		int[] sortedData = new int[data.length];
		mergeSort(data, 0, data.length, sortedData);
		// merge sort with new arrays for left, right and sorted array
//		int[] sortedData = mergeSort(data);		
		printData("Sorted Data ...", sortedData);
	}



	private static void mergeSort(int[] data, int startIndex, int endIndex, int[] sortedData) {
//		System.out.println("startIndex: " + startIndex + " endIndex: " + endIndex);
		if(endIndex - startIndex < 2) {
			return;
		}
		int leftEnd = startIndex + (endIndex - startIndex)/2;
		int rightStart = leftEnd ;
		
		mergeSort(data, startIndex, leftEnd, sortedData);
//		printData("Splitted left Data ...", data, startIndex, leftEnd);
		
		mergeSort(data, rightStart, endIndex, sortedData);
//		printData("Splitted right Data ...", data, rightStart, endIndex);
		
		merge(data, sortedData, startIndex, leftEnd, rightStart, endIndex);
//		printData("Sorted Data ...", data, startIndex, leftEnd, rightStart, endIndex);
	}



	private static void printData(String message, int[] sortedData, int startIndex, int endIndex) {
		System.out.print(message);
		for(int i=startIndex; i< endIndex; i++) {
			System.out.print(sortedData[i] +", ");
		}
		System.out.println("");
	}

	private static void printData(String message, int[] sortedData, int startLeftIndex, int endLeftIndex, int startRightIndex, int endRightIndex) {
		System.out.print(message);
		for(int i=startLeftIndex; i< endLeftIndex; i++) {
			System.out.print(sortedData[i] +", ");
		}
		for(int i=startRightIndex; i< endRightIndex; i++) {
			System.out.print(sortedData[i] +", ");
		}
		System.out.println("");
	}



	private static void merge(int[] data, int[] sortedData, int leftStart, int leftEnd, int rightStart, int endIndex) {
		int index = 0;
		int leftIndex = leftStart;
		int rightIndex = rightStart;
		while(leftIndex < leftEnd && rightIndex < endIndex) {
			if(data[leftIndex] <= data[rightIndex]) {
				sortedData[index] = data[leftIndex];
				leftIndex++;
			} else {
				sortedData[index] = data[rightIndex];
				rightIndex++;
			}
			index++;
		}
		
		for(int i=leftIndex; i<leftEnd; i++) {
			sortedData[index] = data[i];
			index++;
		}
		for(int i=rightIndex; i<endIndex; i++) {
			sortedData[index] = data[i];
			index++;
		}
		
		index = 0;
		for(int i=leftStart; i<leftEnd; i++) {
			data[i] = sortedData[index];
			index++;
		}
		for(int i=rightStart; i<endIndex; i++) {
			data[i] = sortedData[index];
			index++;
		}

	}



	private static int[] mergeSort(int[] data) {
		if(data.length < 2)
			return data;
		int midPoint = data.length/2;
		int[] leftData = populateDataToLeftArray(data, midPoint);
		int[] rightData = populateDataToRightArray(data, data.length - midPoint);
		int[] sortedLeftData = mergeSort(leftData);
		int[] sortedRightData = mergeSort(rightData);
		int[] sortedData = merge(sortedLeftData, sortedRightData);
		return sortedData;
	}

	private static int[] merge(int[] leftData, int[] rightData) {
		int[] sortedData = new int[leftData.length + rightData.length];
		int index = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex < leftData.length && rightIndex < rightData.length) {
			if(leftData[leftIndex] <= rightData[rightIndex]) {
				sortedData[index] = leftData[leftIndex];
				leftIndex++;
			} else {
				sortedData[index] = rightData[rightIndex];
				rightIndex++;				
			}
			index++;
		}
		
		for(int i = leftIndex; i< leftData.length; i++) {
			sortedData[index] = leftData[i];			
			index++;					
		}

		for(int i = rightIndex; i< rightData.length; i++) {
			sortedData[index] = rightData[i];
			index++;					
		}

		return sortedData;
	}

	private static int[] populateDataToLeftArray(int[] srcdata, int destSize) {
		int[] destData = new int[destSize];
		for (int i =0; i < destSize; i++) {
			destData[i] = srcdata[i];
		}
		return destData;
	}

	private static int[] populateDataToRightArray(int[] srcdata, int destSize) {
		int[] destData = new int[destSize];
		for (int i =0; i < destSize; i++) {
			destData[i] = srcdata[srcdata.length - destSize + i];
		}
		return destData;
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
