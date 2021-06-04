package com.dsalgo.test;

import java.util.Stack;

public class Parenthesis {
    public static boolean checkProperParenthesis(String string) {
        Stack<Character> s1 = new Stack<>();


        for(char c: string.toCharArray()) {
            if (c == '{') s1.push(c);
            else if (c == '}') {
               if (s1.pop() != '{') { return false;}
            }

        }

        if (!s1.isEmpty()) return false;
        return true;

    }


    public static void main(String args[]) {
        Parenthesis pr = new Parenthesis();
        System.out.println(Parenthesis.checkProperParenthesis("{{}}{{{{}{}{}{}}}}{}{"));
    }
}
