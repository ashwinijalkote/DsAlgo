package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

public class MinHeap {
    List<Integer> arr;
    int heapsize;

    MinHeap(List<Integer> arr) {
        this.arr = arr;
        this.heapsize = arr.size();
    }

    public void buildHeap() {
        for(int i = arr.size()/2 -1; i >= 0; i--) {
            heapify(i);
        }
        out.println(arr);
    }

    private int getLeftIndex(int parentIndex) {
        return 2*parentIndex;
    }

    private int getRightIndex(int parentIndex) {
        return 2*parentIndex + 1;
    }

    public void heapify(int i) {
        int leftIndex;
        int rightIndex;
        int minIndex = -1;

        leftIndex = getLeftIndex(i);
        rightIndex = getRightIndex(i);

        if (leftIndex < heapsize && arr.get(leftIndex) < arr.get(i)) {
            minIndex = leftIndex;
        } else {
            minIndex = i;
        }
        if (rightIndex < heapsize && arr.get(rightIndex) < arr.get(minIndex)) {
            minIndex = rightIndex;
        }
        if (minIndex != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);

            heapify(minIndex);
        }
    }

    public List<Integer> getArr() {
        return arr;
    }



    public static void main(String args[]) {
        out.println(KLargest.getKLargest(Arrays.asList(20, 4, 10, 5, 39, 80, 3, 50, 67, 40), 5));

        //out.println(Arrays.asList(20, 10).add(30));

        new ArrayList<>().add(1);
    }

}


class KLargest {

    public static List<Integer> getKLargest(List<Integer> numbers, int k) {
        MinHeap minHeap = new MinHeap(numbers.subList(0,k));
        minHeap.buildHeap();
        List<Integer> minHeapOfKElts;
        for(int i = (numbers.size() - k); i < numbers.size(); i++){
            minHeapOfKElts = minHeap.getArr();
            if (minHeapOfKElts.get(0) > numbers.get(i)) {
                continue;
            }
            minHeapOfKElts.set(0, numbers.get(i));
            out.println("after replace:  " + numbers.get(i)+ " " + minHeap.getArr());
            minHeap.heapify(0);
            out.println("after heapify:" + minHeap.getArr());
        }
        return minHeap.getArr();


    }
}