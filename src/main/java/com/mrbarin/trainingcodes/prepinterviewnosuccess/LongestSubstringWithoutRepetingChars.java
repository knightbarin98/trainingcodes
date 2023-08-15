package com.mrbarin.trainingcodes.prepinterviewnosuccess;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a string s, find the length of the longest 
	substring
 	without repeating characters. 
 
 * 	Input: s = "abcabcbb"
 	Output: 3
  	Explanation: The answer is "abc", with the length of 3.
  	
  	Input: s = "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.
  	
  	Input: s = "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3.
	Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepetingChars {
	
	public static void main(String [] args) {
		LongestSubstringWithoutRepetingChars t = new LongestSubstringWithoutRepetingChars();
		int i = t.lengthOfLongestSubstring("dvdf");
		System.out.println(i);
	}
	public int lengthOfLongestSubstring(String s) {
		if(s.length() == 1) return 1;
		String res = "";
		int []hash = new int[128];
		int l = 0;
		int r = 0;
		while(l<s.length()&& r<s.length())
		{
			char c = s.charAt(r);
			if(hash[c] == 0) {
				hash[c] = 1;
				r++;
			}else {
				l++;
				r = l;
				hash = new int[128];
			}
			String temp = s.substring(l,r);
			if(!temp.equals(res) && temp.length() > res.length()) {
				res = s.substring(l,r);
			}
			System.out.println(l);
			System.out.println(r);
			System.out.println(res);
		}
		return res.length();
	}
	
	public int lengthOfLongestSubstring2(String s) {
        Set<Character>set=new HashSet<>();
        int maxLength=0;
        int left=0;
        for(int right=0;right<s.length();right++){
           
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength=Math.max(maxLength,right-left+1);
                
            }else{
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));left++;
                set.add(s.charAt(right));
            }
            
        }
        return maxLength;
    }
}
