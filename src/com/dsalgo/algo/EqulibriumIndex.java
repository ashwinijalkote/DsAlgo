package com.dsalgo.algo;

import java.util.Scanner;

public class EqulibriumIndex {

//    public int findEquilibriumIndex(int arr) {
//
//    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int arr[] = new int[n];
//        for(int i=0; i< n; i++) {
//            arr[i] = sc.nextInt();
//        }


        String inputString = sc.nextLine();

        String arr[] = inputString.split(",");
        int arrInt[] = new int[arr.length];
        for(int i=0; i< arr.length; i++) {
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(arr);
    }
}
