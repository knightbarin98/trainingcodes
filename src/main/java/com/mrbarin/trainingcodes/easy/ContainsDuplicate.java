package com.mrbarin.trainingcodes.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class ContainsDuplicate {

	// Driver Code
		public static void main(String[] args)
		{
			int[] arr = { 10, 7, 8, 9, 1, 5 };
			int N = arr.length;

			// Function call
			GFG.quickSort(arr, 0, N - 1);
			System.out.println("Sorted array:");
			GFG.printArr(arr);
		}
	
	public boolean containsDuplicate(int[] nums) {
		Map<Integer,Integer> count = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			if(count.containsKey(nums[i])) {
				return true;
			}else {
				count.put(nums[i], 1);
			}
		}
		return false;
	}
	
	public boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		boolean res = false;
		for(int i=0;i<nums.length;i++) {
			res = binarySearch(nums,i+1, nums[i]);
			if(res) return res;
		}
		return res;
	}
	
	private boolean binarySearch(int [] nums, int i, int key) {
		int l,r;
		l = i;
		r = nums.length-1;
		
		while(l<=r) {
			int mid = (l+r)/2;
			if(nums[mid] == key ) {
				return true;
			}
			else if(key< nums[mid]) {
				r = mid -1; 
			}
			else{
				l = mid +1;
			}
		}
		
		
		return false;
	}

}


class GFG {

	// A utility function to swap two elements
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// This function takes last element as pivot,
	// places the pivot element at its correct position
	// in sorted array, and places all smaller to left
	// of pivot and all greater elements to right of pivot
	static int partition(int[] arr, int low, int high)
	{
		// Choosing the pivot
		int pivot = arr[high];

		// Index of smaller element and indicates
		// the right position of pivot found so far
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			// If current element is smaller than the pivot
			if (arr[j] < pivot) {

				// Increment index of smaller element
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	// The main function that implements QuickSort
	// arr[] --> Array to be sorted,
	// low --> Starting index,
	// high --> Ending index
	static void quickSort(int[] arr, int low, int high)
	{
		if (low < high) {

			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	// To print sorted array
	public static void printArr(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	
}


