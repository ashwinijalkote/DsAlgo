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

        try{

            throw new Exception("exception");
        }catch(Exception e) {
            System.out.println("inside catch");
            //System.exit(1);
            return ;
        }finally {
            System.out.println("ind=side finally after return");
        }
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
