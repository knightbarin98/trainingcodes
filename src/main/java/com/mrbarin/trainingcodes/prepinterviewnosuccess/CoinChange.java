package com.mrbarin.trainingcodes.prepinterviewnosuccess;

public class CoinChange {
	public static void main(String [] args) {
		CoinChange c = new CoinChange();
		int []t = {2};
		int res = c.coinChange(t,3);
		System.out.println(res);
	}
	public int coinChange(int[] coins, int amount) {
		int [] dp = new int[amount + 1];
        for(int i=1;i<=amount;i++) { dp[i] = amount+1;}
		dp[0] = 0;
		
		for(int a =1; a<=amount; a++) {
			for(int c: coins) {
				if((a-c) >= 0) {
					dp[a] = Math.min(dp[a], 1 + dp[a-c]);
				}
			}
		}
		
		return dp[amount] != amount+1 ? dp[amount] : -1;
	}
}
