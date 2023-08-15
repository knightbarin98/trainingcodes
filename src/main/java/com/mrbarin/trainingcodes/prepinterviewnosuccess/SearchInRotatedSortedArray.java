package com.mrbarin.trainingcodes.prepinterviewnosuccess;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
        int l,r;
        l=0; r=nums.length-1;
        while(l<=r) {
        	int mid = (l+r)/2;
        	if(nums[mid] == target) return mid;
        	//check if we are in the left sorted portion
        	if(nums[l] <= nums[mid]) {
        		if(target>nums[mid] || target < nums[l]) {
        			l = mid +1;
        		}else {
        			r = mid -1;
        		}
        	}
        	//check if we are in the right sorted portion
        	else {
        		if(target<nums[mid] || target>nums[r]) {
        			r = mid -1;
        		}
        		else {
        			l = mid +1;
        		}
        	}
        }
        return -1;
    }
}
