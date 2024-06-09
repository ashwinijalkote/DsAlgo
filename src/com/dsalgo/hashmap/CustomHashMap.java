package com.dsalgo.hashmap;

public class CustomHashMap<K,V> {
    private static int INITIAL_CAPACITY = 16;

    CustomEntry[] chMap = new CustomEntry[INITIAL_CAPACITY];

    private int getIndex(K key) {
        return key.hashCode() % INITIAL_CAPACITY;
    }
    public boolean containsKey(K key) {
        int index = getIndex(key);
        if (chMap[index] == null) {
          return false;
        } else {
            CustomEntry temp = chMap[index];
            CustomEntry t = temp;
            while(t != null) {
                if (t.key.equals(temp.key))
                    return true;
                t = t.next;
            }
            return false;
        }
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        if (chMap[index] == null) {
            chMap[index] = new CustomEntry(key, value);
        } else {
            CustomEntry temp = chMap[index];
            CustomEntry t = temp;
            while(t != null) {
                if (t.key.equals(key) ) {
                    t.value = value;
                    return;
                }
                t = t.next;
            }
            t.next = new CustomEntry(key, value);
        }
    }

    public void print() {
        for (int i =0; i< chMap.length; i++) {
            CustomEntry temp = chMap[i];
            while(temp != null) {
                System.out.println(temp.key + " " + temp.value);
                temp = temp.next;
            }
        }
    }


    public static void main(String args[]) {
        CustomHashMap hm = new CustomHashMap<String, Integer>();
        hm.put("a1", 1);
        hm.put("a2", 2);
        System.out.println(hm.containsKey("a1"));
        hm.put("a1", 3);

        hm.print();

    }
}

class CustomEntry<K,V> {
    K key;
    V value;
    int hashValue;
    CustomEntry next;

    public CustomEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hashValue = key.hashCode();

    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public int getHashValue() {
        return hashValue;
    }

}


