package com.mrbarin.trainingcodes.prepinterviewnosuccess;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak w = new WordBreak();
		System.out.println(w.wordBreak("leetcode", Arrays.asList("leet", "code")));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[s.length()] = true;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (String w : wordDict) {
				if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
					dp[i] = dp[i + w.length()];
				}
				if (dp[i])
					break;
			}
		}

		return dp[0];
	}

	private final Map<Integer, Boolean> cache = new HashMap<>();

	public boolean wordBreak2(String s, List<String> wordDict) {
		return canBreak(s, 0, wordDict);
	}

	private boolean canBreak(String s, int index, List<String> wordDict) {
		if (index == s.length()) {
			return true;
		}

		if (cache.get(index) != null)
			return cache.get(index);

		for (String word : wordDict) {
			if (s.substring(index).startsWith(word) && canBreak(s, index + word.length(), wordDict)) {
				cache.put(index, true);
				return true;
			}
		}

		cache.put(index, false);
		return false;
	}
}
