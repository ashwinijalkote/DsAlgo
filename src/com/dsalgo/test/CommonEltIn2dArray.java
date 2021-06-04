package com.dsalgo.test;

import java.awt.*;
import java.util.HashMap;

public class CommonEltIn2dArray {

    public static void commonElt(int [][] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int k =0;
        while (k < arr[0].length) {
            hm.put(arr[0][k], 0);
            k++;
        }
        for (int i=1; i< arr.length; i++) {
            for(int j= 0; j< arr[i].length; j++) {
                if ((hm.containsKey(arr[i][j]) && hm.get(arr[i][j]) == i-1 )) {
                    hm.put(arr[i][j], i);
                }

                if (i == arr.length -1 ) {
                    if (hm.containsKey(arr[i][j]) && hm.get(arr[i][j]) == i ) {
                        System.out.println(arr[i][j]);
                    }
                }
            }
        }
    }

    public static  void main(String args[]) {
        int arr[][] = {
                {1,2,3,4},
                {3, 2,6,7},
                {3,2,5,7},
                {2,3,6,7},
                {2,3,6,7}
        };
        CommonEltIn2dArray.commonElt(arr);

    }
}
