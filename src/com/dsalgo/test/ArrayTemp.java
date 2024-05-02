package com.dsalgo.test;

import java.util.Arrays;

public class ArrayTemp {


    public static int[] eltsStartingWithOne(int [] arr) {
        return Arrays.stream(arr).mapToObj(elt ->  Integer.toString(elt)).filter(elt -> elt.startsWith("1"))
                .mapToInt(elt -> Integer.parseInt(elt)).toArray();
    }

    public static void main(String args[]) {
        int [] arr = { 1, 2, 3, 11, 20, 110};

        int []result = eltsStartingWithOne(arr);

       for (int i =0; i< result.length; i++) {
           System.out.println(result[i]);
       }
    }
}
