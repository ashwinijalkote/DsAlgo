package com.dsalgo.string;

import java.util.ArrayList;

public class Permutations {

    public static void main(String args[]) {
        System.out.println(getPerms("abc"));
    }

    public static ArrayList<String> getPerms(String input) {
        ArrayList<String> output = new ArrayList<>();

        if (input == null) {
            return output;
        }
        if (input.length() == 0) {
            output.add("");
            return output;
        }
        char first = input.charAt(0);
        String remainder = input.substring(1);

        ArrayList<String> permsOfRemainder = getPerms(remainder);
        for(String word: permsOfRemainder) {
            for (int j=0; j<= word.length() ; j++) {
                output.add(addCharAt(first, word, j));
            }
        }
        return output;
    }

    private static String addCharAt(char first, String remainder, int i) {
        System.out.println(remainder.substring(0,i) + first + remainder.substring(i));
        return remainder.substring(0,i) + first + remainder.substring(i);
    }
}
