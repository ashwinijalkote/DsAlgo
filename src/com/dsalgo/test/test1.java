package com.dsalgo.test;

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
    }
}
