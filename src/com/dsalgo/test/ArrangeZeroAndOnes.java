package com.dsalgo.test;

import java.util.Arrays;

public class ArrangeZeroAndOnes {


    public static void arrange(int []arr) {
        int i=0, j=arr.length-1;

        while(i < j) {
            if (arr[i] == 0) {
                i++;
            }
            if (arr[j] == 1) {
                j--;
            }
            if (i< j && arr[i] == 1 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {
        int [] arr = {1,1,1,0, 1,1,0,0,0, 1,1,0,1, 0,1,0,0,0,0,1,1,1,0,1,0,0};
        arrange(arr);

    }
}
