package com.dsalgo.algo;

public class MedianOfTwoSortedArrays {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] smallArrA = nums1.length < nums2.length ? nums1 : nums2;
        int [] largeArrB = nums1.length >= nums2.length ? nums1 : nums2;

        int lengthA = smallArrA.length;
        int lengthB = largeArrB.length;

        int low =0;
        int high = lengthA;
        while(low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (lengthA + lengthB + 1) / 2 - partitionA;

            int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : smallArrA[partitionA - 1];
            int minRightA = partitionA == lengthA ? Integer.MAX_VALUE : smallArrA[partitionA];

            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : largeArrB[partitionB - 1];
            int minRightB = partitionB == lengthB ? Integer.MAX_VALUE : largeArrB[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((lengthA + lengthB) % 2 == 0) {
                    return ((double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2);
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = partitionA -1;
            } else {
                low = partitionA +1;
            }
        }
        return 0.0;
    }


    public static void main(String args[]) {
        int [] nums1 = new int[] {1,3};
        int [] nums2 = new int[] {2, 4, 6};
        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));

    }
}
