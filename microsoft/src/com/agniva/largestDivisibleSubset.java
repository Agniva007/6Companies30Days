package com.agniva;

//https://leetcode.com/problems/largest-divisible-subset/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class largestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(lds(new int[]{1,2,3}));
    }

    public static List<Integer> lds(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0; i<n; i++)
            dp[i] = 1;

        int[] hash = new int[n];

        int maxi = 1;
        int lastIndex = 0;

        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            hash[i] = i;
            for(int prev=0; prev<i; prev++){
                if(nums[i]%nums[prev]==0 && dp[i]<dp[prev]+1){
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }

            if(dp[i] > maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }

        Collections.reverse(temp);
        return temp;
    }
}
