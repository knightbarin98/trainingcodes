package com.mrbarin.trainingcodes.prepinterviewnosuccess;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		int i = l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
		System.out.println(i);

	}
	
	public int lengthOfLIS(int[] nums) {
		TreeSet<Integer> set = new TreeSet<>();

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null) {
                set.remove(ceiling);
            }

            set.add(nums[i]);

        }

        return set.size();
	}
	
	/*private int buildArrays(List<List<Integer>> listsOfArrays, 
			int []nums,int j, int k, int[]tree, int treeCont) {
		if(k == nums.length) {
			List<Integer> temp = new ArrayList<Integer>();
			int cont = 0;
			while(cont < tree.length && tree[cont] != 0) {
				temp.add(tree[cont]);
				cont++;
			}
			listsOfArrays.add(temp);
			return 0;
		}
		
		for(int i=k;i<nums.length;i++) {
			if(nums[j]<nums[k]) {
				tree[treeCont++] = nums[j];
				tree[treeCont++] = nums[k];
				j=k;
				treeCont = buildArrays(listsOfArrays, nums,j, k+1, tree, treeCont);
				if(treeCont == 0) {
					tree = new int[nums.length];
				}
			}
		}
		
		return 0;
	}
	
	public int lengthOfLIS(int[] nums) {
		List<List<Integer>> listsOfArrays = new ArrayList<List<Integer>>();
		buildArrays(listsOfArrays, nums, 0, new int[nums.length], 0);
		int max = 0;
		for(List<Integer> list: listsOfArrays) {
			if(list.size()>max) max = list.size();
		}
        return max;
    }*/

}
