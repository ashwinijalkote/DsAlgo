package com.dsalgo.test;

public class Assignment {

    private static void printMsg(int no) {

        if (no % 2 == 0) {
            System.out.print("Fuz");
        }
        if(no % 3 ==0) {
            System.out.print("Buz");
        }
    }

    private static void printLines1() {
        String str = "ATTACHED ARE SOME OF THE SCREENSHOTS THE ALERT TOKEN TEXT CONTENT SHOULD BE ALIGNED WITHOUT BREAKING THE WORD";
        int cnt = 0;
        int MAX_LENGTH = 20;
        while (cnt < str.length()) {
            while(Character.isWhitespace(str.charAt(cnt))) {
                cnt++;
            }
            if (cnt + MAX_LENGTH > str.length()) {
                System.out.println(str.substring(cnt));
                cnt+=MAX_LENGTH;
            } else if (Character.isWhitespace(str.charAt(cnt + MAX_LENGTH))) {
                System.out.println(str.substring(cnt, cnt + MAX_LENGTH));
                cnt += MAX_LENGTH;
            } else if (Character.isWhitespace(str.charAt(cnt + MAX_LENGTH +1))) {
                System.out.println(str.substring(cnt , cnt + MAX_LENGTH));
                cnt += MAX_LENGTH;
            } else {
                int endCount = cnt+MAX_LENGTH;
                while (!Character.isWhitespace(str.charAt(endCount--))) {
                    continue;
                }
                System.out.println(str.substring(cnt, endCount+1));
                cnt = endCount+2;
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("Print msg for given number");
        printMsg(3);
        System.out.println("\nPrinting lines split into multiple lines with max 20 chars");
        printLines1();
    }
}
