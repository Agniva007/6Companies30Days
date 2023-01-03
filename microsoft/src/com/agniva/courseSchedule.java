package com.agniva;

// https://leetcode.com/problems/course-schedule/
import java.util.ArrayList;

public class courseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int visi[] = new int[numCourses];
        int path[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visi[i] == 0) {
                if (dfs(visi, i, arr, path) == true) {
                    System.out.println(i);
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean dfs(int vis[], int n, ArrayList<ArrayList<Integer>> arr, int path[]) {
        vis[n] = 1;
        path[n] = 1;
        for (int i = 0; i < arr.get(n).size(); i++) {
            if (vis[arr.get(n).get(i)] == 0) {
                if (dfs(vis, arr.get(n).get(i), arr, path) == true) {
                    return true;
                }
            } else {
                if (path[arr.get(n).get(i)] == 1) {
                    return true;
                }
            }
        }

        path[n] = 0;
        return false;
    }

}
