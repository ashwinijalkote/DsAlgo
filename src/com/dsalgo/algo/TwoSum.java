package com.dsalgo.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> temp = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(target - nums[i])) {
                return  new int []{i,temp.get(target -  nums[i])};
            } else {
                Integer put = temp.put(nums[i], i);
            }
        }
        return new int []{};
    }

    public static void main(String args[]) {
        int [] arr = {-2,7,11, -15};
        int []output = TwoSum.twoSum(arr, -4);
        for(int i=0; i < output.length; i++) {
            System.out.print(output[i] + "\t");
        }
    }
}
