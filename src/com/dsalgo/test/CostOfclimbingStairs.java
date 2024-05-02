package com.dsalgo.test;

public class CostOfclimbingStairs {

    public static  int minCostClimbingStairs(int[] cost) {

        if (cost.length == 1) {
            return 0;
        }
        if (cost.length == 2) {
            return Math.min(cost[0],cost[1]);
        }

        int i = 2;
        int temp = 0;
        int costAtOneStepBefore = Math.min(cost[1], cost[0] + cost[1]);
        int costAtTwoStepsBefore = cost[0];

        while (i < cost.length) {
            temp = costAtOneStepBefore;
            costAtOneStepBefore = Math.min(costAtOneStepBefore + cost[i], costAtTwoStepsBefore + cost[i]);
            costAtTwoStepsBefore = temp;
            System.out.println(costAtOneStepBefore + " " + costAtTwoStepsBefore);
            i++;
        }
        return Math.min(costAtOneStepBefore, costAtTwoStepsBefore);
    }
    public static void main(String args[]) {
        int []temp = new int[] {1, 100};
        System.out.println(minCostClimbingStairs(temp));
    }
}
