package com.dsalgo.arrays;

public class BinarySearchInRotatedArray {

    public static int findElt(int []arr, int elt, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low )/2;

        if (arr[mid] == elt) {
            return mid;
        }

        //if (arr[])
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {7,8,9, 1, 2,3, 4,5 };
        System.out.println(findElt(arr, 2, 0, arr.length-1));

    }
}
