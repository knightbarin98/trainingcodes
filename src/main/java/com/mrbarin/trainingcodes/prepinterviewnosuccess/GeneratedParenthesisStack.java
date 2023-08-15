package com.mrbarin.trainingcodes.prepinterviewnosuccess;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * only add open parenthesis of open < n
 * only add closing parenthesis if closed < open
 * valid IFF open === closed == n
 */
public class GeneratedParenthesisStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneratedParenthesisStack g = new GeneratedParenthesisStack();
		List<String> res = g.generateParenthesis(3);
		res.forEach(System.out::println);
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        Deque<Character> stack = new ArrayDeque<Character>();
        backtracking(stack, combinations, n, 0, 0);
        return combinations;
    }
	
	private void backtracking(Deque<Character> stack, List<String> combinations,int n, int openN, int closedN) {
		if(openN == closedN && openN == n) {
			StringBuilder temp = new StringBuilder();
			stack.stream().forEachOrdered(c ->temp.insert(0,String.valueOf(c)));
			combinations.add(temp.toString());
		}
		
		if(openN<n) {
			stack.push('(');
			backtracking(stack, combinations, n, openN+1, closedN);
			stack.pop();
		}
		
		if(closedN < openN) {
			stack.push(')');
			backtracking(stack, combinations, n, openN, closedN+1);
			stack.pop();
		}
	}

}
