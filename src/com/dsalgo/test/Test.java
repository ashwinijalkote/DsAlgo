package com.dsalgo.test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<SuperClass> queue = new LinkedBlockingQueue();

        //SuperClass superClass = new SuperClass();
        SuperClass superClass1 = new Subclass1();
        SuperClass superClass2 = new Subclass2();
        queue.add(superClass1);
        queue.add(superClass2);
        //System.out.println(superClass instanceof SuperClass);
        System.out.println(superClass1 instanceof Subclass1); // true
        System.out.println(superClass2 instanceof Subclass2);// true
        System.out.println(superClass2 instanceof Subclass1);// false
        System.out.println(superClass1 instanceof Subclass2);// false
        System.out.println(superClass1.getClass());// false
        System.out.println(superClass2.getClass());// false





        List<List<Integer>> number = new ArrayList<>();


        number.add(Arrays.asList(1, 2));
        number.add(Arrays.asList(3, 4));
        number.add(Arrays.asList(5, 6));
        number.add(Arrays.asList(7, 8));

        //[[[1],[2]], [[3],[4]], [[5],[6]], [[7],[8]]]
        System.out.println(number.stream().flatMap(Collection::stream).collect(Collectors.toList()));


        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);

        List<Integer> a1= Arrays.stream(s1.toArray()).map(Object::toString).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(a1);

        Set<Integer> set = new HashSet<>();

        try{

            throw new Exception("exception");
        }catch(Exception e) {
            System.out.println("inside catch");
          //  System.exit(1);
            //return ;
        }finally {
            System.out.println("ind=side finally after return");
        }

        int sum =3;
        sum ^= 1;
        System.out.println(sum);

        System.out.println("print hex string");
        print();
    }


    public static void print() {

        String str = "";
        StringBuffer indexStr = new StringBuffer();

        StringBuffer finalStr = new StringBuffer();
        for (int i =0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                finalStr.append(' ');
                indexStr.append(' ');
            } else {
                finalStr.append(getHex(getValue(Character.toUpperCase(str.charAt(i)))));
            }
        }

        System.out.println(finalStr);

    }

    public static int getValue(Character ch) {
        return Character.getNumericValue(ch)  - Character.getNumericValue('a') + 1 ;
    }
    public static String getHex(int num) {
        String hexString = "0123456789ABCDEF";
        StringBuffer str = new StringBuffer();
        int r;
        while (num > 0) {
            r = num%16;
            num = num/16;
            str.append(hexString.charAt(r));
        }
        return str.toString();
    }


    public static String getOct(int num) {
        String octString = "01234567";
        StringBuffer str = new StringBuffer();
        int r;
        while (num > 0) {
            r = num%8;
            num = num/8;
            str.append(octString.charAt(r));
        }
        return str.toString();
    }


}

//class SuperClass {
//
//}

interface SuperClass {

}
class Subclass1 implements SuperClass {

}

class Subclass2 implements SuperClass {

}

class Subclass extends Subclass1 {

}

