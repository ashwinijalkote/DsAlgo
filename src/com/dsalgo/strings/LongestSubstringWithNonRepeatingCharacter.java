package com.dsalgo.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNonRepeatingCharacter {

    public static  int findLengthOfLongestSubStringWithNonRepeatingCharacter(String temp) {

        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j=0, i=0; j < temp.length(); j++) {
            if (map.containsKey(temp.charAt(j))) {
                i = Math.max(map.get(temp.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j-i+1);
            map.put(temp.charAt(j), j+1);
        }
        return maxLength;
    }

    public static void main(String args[]) {
        String temp = "abcdeafghadehfibnknn";

        System.out.println(findLengthOfLongestSubStringWithNonRepeatingCharacter(temp));


    }
}
