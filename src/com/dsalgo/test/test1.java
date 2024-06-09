package com.dsalgo.test;

import java.util.HashMap;
import java.util.Map;

public class test1 {


    public static String reverse(String temp) {
        StringBuffer sb = new StringBuffer();
        for(int i=temp.length()-1; i >=0; i--) {
            sb.append(temp.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String args[]) {

        System.out.println(reverse("Ashwini"));

        Map hm = new HashMap<String, Integer>();
        String t1 = "t1";
        Integer v1 = 1;
        String t11 = "t1";
        Integer v2 = 2;


        hm.put(t1,v1);
        System.out.println(hm.containsKey(t1));
        System.out.println(t1.hashCode());
        System.out.println(t11.hashCode());
        System.out.println(t11.equals(t1));
        System.out.println(t11.equals("t1"));

        hm.put(t1, v2);
        System.out.println(hm.get(t1));

    }
}
