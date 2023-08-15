package com.mrbarin.trainingcodes.prepinterviewnosuccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleDFSAdjencyMatrix {
	public static void main(String [] args) {
		CourseScheduleDFSAdjencyMatrix  m = new CourseScheduleDFSAdjencyMatrix();
		System.out.println(m.canFinish(5, new int[][] {{1,4},{2,4},{3,1},{3,2}}));
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> preMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < prerequisites.length; i++) {
			List<Integer> temp ;
			if (preMap.containsKey(prerequisites[i][0])) {
				temp = preMap.get(prerequisites[i][0]);
				temp.add(prerequisites[i][1]);
				preMap.put(prerequisites[i][0], temp);
			} else {
				temp = new ArrayList<Integer>();
				temp.add(prerequisites[i][1]);
				preMap.put(prerequisites[i][0], temp);
				if (!preMap.containsKey(prerequisites[i][1])) {
					temp = new ArrayList<Integer>();
					preMap.put(prerequisites[i][1], temp);
				}
			}
		}
		Set<Integer> visitSet = new HashSet<Integer>();
		
		for(int i=0;i<numCourses;i++) {
			if(!dfs(i,visitSet,preMap)) return false;
		}
		
		return true;
	}
	
	private boolean dfs(int course, Set<Integer> visitSet, 
			Map<Integer, List<Integer>> preMap ) {
		
		if(visitSet.contains(course)) return false;
		
		List<Integer> pre = preMap.get(course);
		if(pre == null || pre.isEmpty()) return true;
		
		visitSet.add(course);
		for(Integer i: preMap.get(course)) {
			if(!dfs(i,visitSet,preMap)) return false;
		}
		visitSet.remove(course);
		List<Integer> tmp = preMap.get(course);
		tmp.clear();
		preMap.put(course, tmp);
		return true;
	}
	
	//Literally DFS
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int [] indegree = new int[numCourses];
        boolean [] visited = new boolean[prerequisites.length];
        for (int [] pre : prerequisites) indegree[pre[1]]++;

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i] && indegree[prerequisites[i][0]] == 0) {
                    indegree[prerequisites[i][1]]--;
                    visited[i] = flag = true;
                }
            }
        }
        for (int in : indegree) if (in > 0) return false;
        return true;
    }
}
