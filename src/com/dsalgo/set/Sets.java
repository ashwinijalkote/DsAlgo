package com.dsalgo.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Sets {

    public static void main(String args[]) {
        ArrayList<Integer> input = new ArrayList<>(){
            {
                add(1);add(2);add(3);

            }
        };

    //    System.out.println(getSubSets(input, 0));
    }

//    public static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> input, int index) {
//        Set<ArrayList<Integer>> output = new <ArrayList<Integer>();
//
//        if (index == 0) {
//            output.add(new ArrayList<Integer>());
//        }
//
//        ArrayList<ArrayList<Integer>> prevAllSubSets = getSubSets(input, index - 1);
//        for(ArrayList<Integer> lists : output) {
//
//        }
//        return output;
//    }

    // [1,2,3] = { [], [1], [2], [1,2], [3], [1,2,3]}
}
