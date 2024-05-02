package com.dsalgo.test;

public class Deadlock {


    public static void main(String args[]) throws  InterruptedException {

        SharedObject1 obj1  = new SharedObject1();
        SharedObject2 obj2  = new SharedObject2();
        Thread t1 = new Thread(() -> {
            try {
                obj1.test1();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                obj2.test2();

                obj1.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}

class SharedObject1 {


    public synchronized void test1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " acquired lock " + this.getClass().getName());
        SharedObject2 obj2  = new SharedObject2();
        obj2.test2();
        Thread.sleep(1000);
    }

}

class SharedObject2 {

    public synchronized  void test2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " acquired lock on " + this.getClass().getName());
        SharedObject1 obj1  = new SharedObject1();
        obj1.test1();
        Thread.sleep(1000);

    }
}


