package com.mrbarin.trainingcodes.prepinterviewnosuccess;

public class MaximunProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximunProductSubarray max = new MaximunProductSubarray();
		System.out.println(max);
	}
	
	public int maxProduct(int[] nums) {
        int max = nums[0];
		for(int i=0; i<nums.length; i++) {
        	if(nums[i]>max) max = nums[i];
        }
		
		int curMin, curMax; curMin = curMax = 1;
		
		for(int n: nums) {
			if(n == 0) {
				curMin = curMax = 1;
				continue;
			}
			int tmp = curMax * n;
			curMax = Math.max(Math.max(n*curMax, n*curMin), n);
			curMin = Math.min(Math.min(tmp, n*curMin), n);
			
			max = Math.max(curMax, max);
			
			
		}
        
        return max;
    }

}
