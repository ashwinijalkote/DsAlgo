package com.dsalgo.string;

import java.util.*;

public class KMostFrequesntInAlphabeticOrder {

    public static void topKFrequent(String [] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i< words.length; i++) {
            hm.put(words[i], hm.getOrDefault(words[i], 0) +1);
        }

        List<String> wordsList = new ArrayList<>(hm.keySet());
        wordsList.stream().sorted((s1, s2) -> {
            System.out.println(s1 +" \t" + s2);
            return hm.get(s1) > hm.get(s2) ? 1 : (hm.get(s1) == hm.get(s2)) ? s1.compareTo(s2) : -1;
        });

        System.out.println(wordsList.subList(0,k));

    }

    public static void main(String args[]) {
        String [] list = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "is", "is", "is"};
        KMostFrequesntInAlphabeticOrder.topKFrequent(list, 3);
    }
}
