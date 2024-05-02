package com.dsalgo.numbers;

import java.beans.PropertyEditorSupport;
import java.io.*;
import java.util.*;


public class TestClass {
    static long[] result = new long[1000001];
    static HashMap<Integer, Boolean> hMap = new HashMap<>();
    static {
        hMap.put(1, true);
        hMap.put(4, false);
        hMap.put(16, false);
        hMap.put(37, false);
        hMap.put(58, false);
        hMap.put(89, false);
        hMap.put(145, false);
        hMap.put(42, false);
        hMap.put(20, false);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        long t1 , t2;
        t1 = System.currentTimeMillis();
        precompute();
        t2 = System.currentTimeMillis();

        wr.write((t2- t1) + " precompute \n");


        for(int t_i = 0; t_i < T; t_i++)
        {

            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);


            t1 = System.currentTimeMillis();
            long out_ = solve(l, r);
            wr.write(out_+ "\n");
            t2 = System.currentTimeMillis();
            wr.write((t2- t1) + " solve \n");

        }

        wr.close();
        br.close();
    }

    static void precompute() throws IOException {
        for(int i=0; i<= 1000000; i++) {
            if(isBeautiful(i)) {
                result[i]= i;
            }
            if (i > 0) {
                result[i] += result[i-1];
            }
        }


    }

    static long solve(int l, int r){
        return result[r] - result[l-1];
    }

    static boolean isBeautiful(int num) {
        if (hMap.containsKey(num)) {
            return hMap.get(num);
        }
        hMap.put(num, false);
        boolean isBeautiful = helperForIsBeautiful(num);
        hMap.put(num, isBeautiful);
        return isBeautiful;
    }

    static boolean helperForIsBeautiful(int num) {
        int rem, sum=0;
        while(true) {
            rem = num%10;
            sum += (rem * rem);
            num = num/10;
            if (num < 10) {
                sum += (num*num);
                if (hMap.containsKey(sum)) {
                    return hMap.get(sum);
                }
                return isBeautiful(sum);
            }
        }
    }
}