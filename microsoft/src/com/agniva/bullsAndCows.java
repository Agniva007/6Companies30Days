package com.agniva;

// https://leetcode.com/problems/bulls-and-cows/

import java.util.HashMap;

public class bullsAndCows {
    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
    }

    public static String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int a=0, b=0;

        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i)!=guess.charAt(i)){
                if(map.containsKey(secret.charAt(i))){
                    map.put(secret.charAt(i), map.get(secret.charAt(i))+1);
                }else{
                    map.put(secret.charAt(i), 1);
                }
            }
        }

        for(int i=0; i<guess.length(); i++){
            if(guess.charAt(i)==secret.charAt(i)){
                a++;
            }else{
                if(map.containsKey(guess.charAt(i))){
                    if(map.get(guess.charAt(i))>0){
                        b++;
                        map.put(guess.charAt(i), map.get(guess.charAt(i))-1);
                    }
                }
            }
        }

        return a+"A"+b+"B";
    }
}
