package com.agniva;

// https://leetcode.com/problems/rotate-function/
public class rotateFunction {
    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4,3,2,6}));
    }
    /*  We have to try and find some pattern.
    Let arr= [a,b,c,d]
    sum= a+b+c+d

    so, F(0) = 0a + 1b + 2c + 3d
    F(1) = 1a + 2b + 3c + 0d
    F(2) = 2a + 3b + 0c + 1d

    F(1) - F(0) = a + b + c -3d = a+b+c+d-4d
    => F(1) = F(0) + sum - N*arr[1st elem from end]

    F(2) - F(1) = a + b + d -3c = a+b+c+d-4c
    => F(2) = F(1) + sum - N*arr[2nd elem from end]

    SO, the pattern :
    F(k) = F(k-1) + sum - N*arr[N-k]
 */

    public static int maxRotateFunction(int[] nums) {
        int F = 0 ;
        int S = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            F = F + (i*nums[i]);
            S = S + nums[i];
        }
        int n = nums.length;
        int ans = F ;
        for(int i = n -1  ; i >= 1 ; i--){
            F = F + S - n * nums[i];
            ans = Math.max(ans , F);
        }
        return ans ;
    }
}
