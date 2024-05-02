package com.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BuyAndSellStock {

    private int getMaxProfit(int prices[]) {

        int sum = 0;

        for(int i=1; i< prices.length ; i++) {
            if (prices[i] > prices[i-1]) {
                sum += (prices[i] - prices[i-1]);
            }
        }
        return sum;
    }



    public static void main(String args[]) {

        int [] prices = {7,5, 4, 6, 1 ,3};

        Map<Account, Integer> map = new HashMap<>();
        Account a1 = new Account("a", 1);
        Account a2 = new Account("b", 1);
        map.put(a1, 1);
        map.put(a2, 1);

        System.out.println(map.size());

        System.out.println(map.get(a1));

        a1.setName("abcd");
        System.out.println(map.get(a1));
        System.out.println(map.size());
        a1.setName("a");
        System.out.println(map.get(a1));
        System.out.println(map.size());


    }
}

class Account {

    String name;
    Integer id;

    public Account(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name) && Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
