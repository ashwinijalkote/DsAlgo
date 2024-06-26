package com.dsalgo.algo;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output1 = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0; i < nums.length -2; i++) {
            int num1 = nums[i];
            System.out.println(num1 +" "+ nums[i+1]+ " " + (-1 * nums[i] < nums[i+1]));
            if (-1 * nums[i] < nums[i+1] ){
                //continue;
                System.out.println("inside" +(nums[i] * -1) +" "+ nums[i+1]);
                break;
            }
            if (i> 0 && nums[i] == nums[i-1]) {
                System.out.println("" + i + " " + (i-1) );
                continue;
            }
            int j = i+1;
            int k = nums.length -1;

            while(j < k) {
                if (nums[j] + nums[k] < (0 - num1)) {
                    j++;
                } else if (nums[j] + nums[k] > (0- num1)) {
                    k--;
                } else {
                    output1.add(List.of(num1, nums[j], nums[k]));
                    j++; k--;
                }
            }
        }

        return output1.stream().collect(Collectors.toList());
    }

    public static void main(String args[]) {
        int [] arr1 = new int []{-1,0,1,2,-1,-4,-4 -2,2,-3,3,0,4, 5};
        //int [] arr1 = new int []{0,1,2,3,0,4, 5};

            System.out.println(ThreeSum.threeSum(arr1));
    }
}
