package com.mrbarin.trainingcodes.prepinterviewnosuccess;

public class LongestPalindromic {
	
	public String longestPalindrome(String s) {
		//babad
		//check if is a palindrome first part
		//Build palindrome check
		/*if(isPalindrome(s)) return s;
		StringBuilder builder = new StringBuilder(s);
		int r = builder.length()-1;
		int l = 0;
		while(builder.length() != 0) {
			String temp1 = builder.substring(0,l--);
			String temp2 = builder.substring(r++);
			if(isPalindrome(temp1)) return temp1;
			else if(isPalindrome(temp2)) return temp2;
			else builder.replace(r, l, s);
		}*/
		StringBuilder res = new StringBuilder(s);
		int resLen = 0;
		for(int i = 0; i<s.length()-1;i++)
		{
			int l ,r;
			l = r = i;
			while(l>= 0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
				if((r-l + 1) > resLen) {
					res = res.replace(l,r+1,s);
					resLen = r - l  +1;
				}
				l-=1;
				r+=1;
			}
			
			l = i;
			r = i+1;
			while(l>= 0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
				if((r-l + 1) > resLen) {
					res = res.replace(l,r+1,s);
					resLen = r - l  +1;
				}
				l-=1;
				r+=1;
			}
		}
		return res.toString();
	}
	
	private  boolean isPalindrome(String s) {
		StringBuilder builder = new StringBuilder();
		for(int i=s.length()-1;i>=0;i--) {
			builder.append(s.charAt(i));
		}
		return builder.toString().equals(s);
	}

}
