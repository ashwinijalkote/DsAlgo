package com.dsalgo.algo;

import java.util.*;
import java.util.stream.Collectors;


public class MaxSizeSubarrayOfSumK {

    private static int findMaxSizeSubarrayOfSumK(int nums[], int sum) {
        int maxSizeSubarray = 0;
        Map<Integer, StringBuilder> map = new LinkedHashMap(); // sum -> index
        int continuousSum =0;
        for (int i = 0; i < nums.length; i++ ) {
            continuousSum += nums[i];
            if (map.containsKey(continuousSum))
                map.put(continuousSum, map.get(continuousSum).append( "," + (i))); // we can ignore the rest of indexes as it will lead to smaller size ??
            else {
                map.put(continuousSum, new StringBuilder(i+""));
            }
        }
        System.out.println(map);

        List <Integer>indexes =  map.keySet().stream().collect(Collectors.toList());
        int maxSize = 0; int n = indexes.size();

        if (map.containsKey(sum)) {
            maxSize = Arrays.stream(map.get(sum).toString().split(","))
                    .mapToInt((y) -> Integer.parseInt(y))
                    .reduce((a, b) -> (a > b) ? a : b)
                    .orElse(0);
            maxSize = maxSize !=0 ? maxSize + 1: maxSize;

        }
        System.out.println(maxSize);
        for (int i = n-1; i >= 0; i--) {
            int size = 0;
            if (map.containsKey(indexes.get(i) - sum)) {
                int finalI = i;
                size = Arrays.stream(map.get(indexes.get(i)-sum).toString().split(","))
                .mapToInt((y) -> Integer.parseInt(y))
                .map((y) -> (y - finalI))
                .max().orElse(0);
                maxSize = maxSize > size ? maxSize : size;
            }

        }

        return maxSize;
    }

    public static void main(String args[]) {
        //int nums[] = {1,-1,5,-2,3};
        int nums[] ={-2,-1,2,1};
        //int nums[] = {0,0};
       // int size = findMaxSizeSubarrayOfSumK(nums, 3);
        int size = findMaxSizeSubarrayOfSumK(nums, 1);
       //int size = findMaxSizeSubarrayOfSumK(nums, 0);
        System.out.println(size);

    }
}
