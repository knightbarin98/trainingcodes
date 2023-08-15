package com.mrbarin.trainingcodes.prepinterviewnosuccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length;i++)
        {
            int temp = nums[i];
            if(i>0 && temp == nums[i-1]) continue;
            int j = i+1,k = nums.length;
            while(j<k)
            {
                int threeSum = temp + nums[j] + nums[k];
                if(threeSum>0){
                    k -=1;
                }
                else if(threeSum < 0){
                    j += 1;
                }
                else{
                    threeSumList.add(Arrays.asList(temp,nums[j],nums[k]));
                    j += 1;
                    while (nums[j] == nums[j-1] && j<k) j+=1;
                }
            }
        }
        return threeSumList;
    }
}
