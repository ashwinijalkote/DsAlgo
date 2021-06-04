package com.dsalgo.test;

import java.util.concurrent.LinkedBlockingQueue;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<SuperClass> queue = new LinkedBlockingQueue();

       // SuperClass superClass = new SuperClass();
        SuperClass superClass1 = new Subclass1();
        SuperClass superClass2 = new Subclass2();
        queue.add(superClass1);
        queue.add(superClass2);
        //System.out.println(superClass instanceof SuperClass);
        System.out.println(superClass1 instanceof Subclass1);
        System.out.println(queue.take() instanceof Subclass1);
        System.out.println(queue.take() instanceof Subclass2);

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
