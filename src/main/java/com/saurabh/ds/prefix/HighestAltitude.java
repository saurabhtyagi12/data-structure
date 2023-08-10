package com.saurabh.ds.prefix;

// https://leetcode.com/problems/find-the-highest-altitude/submissions/?envType=study-plan-v2&envId=leetcode-75

class HighestAltitude {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] altitudes = new int[n + 1];
        altitudes[0] = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            altitudes[i + 1] = altitudes[i] + gain[i];
            if(altitudes[i+1] > max)
                max = altitudes[i+1];
        }
        return max;
    }
}