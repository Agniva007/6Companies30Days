package com.agniva;
// https://leetcode.com/problems/combination-sum-iii/description/

import java.util.ArrayList;
import java.util.List;

public class combinationSumIII {
    public static void main(String[] args) {
            System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            combination(list, new ArrayList<Integer>(), 1, k, n);
            return list;
    }

    public static void combination(List<List<Integer>> list, List<Integer> sum, int s, int k, int n){
            if(sum.size()==k && n==0){
                List<Integer> li = new ArrayList<Integer>(sum);
                list.add(li);
                return;
            }

            for(int i=s; i<=9; i++){
                sum.add(i);
                combination(list, sum, i+1, k, n-i);
                sum.remove(sum.size()-1);
            }
    }

}
