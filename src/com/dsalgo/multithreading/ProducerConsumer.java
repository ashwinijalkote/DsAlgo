package com.dsalgo.multithreading;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

class ProducerConsumer {

    public static void main(String args[]) {

        Object fullCondition = new Object();
        Object emptyCondition = new Object();
        SharedQueue q = new SharedQueue(fullCondition, emptyCondition);
        Producer  producer1= new Producer(q, "producer1");
      //  Producer  producer2= new Producer(q, "producer1");
        Consumer  consumer1= new Consumer(q, "consumer1");
        //Consumer  consumer2= new Consumer(q, "consumer1");

    }
}

class SharedQueue {
    int elts[];
    private static int MAX_CAPACITY = 5;
    Object fullCondition;
    Object emptyCondition;


    int cnt=0;
    SharedQueue(Object fullCondition, Object emptyCondition) {
        this.fullCondition = fullCondition;
                this.emptyCondition = emptyCondition;
        elts = new int[MAX_CAPACITY];
    }

    public void  produce() throws InterruptedException {
        synchronized(this) {
            while(cnt == MAX_CAPACITY -1) {
                wait();
            }
            this.elts[cnt] = cnt++;
            System.out.println("Produced:" + this.elts[cnt - 1]);
            notify();

            }
        }



    public void consume() throws InterruptedException {
        synchronized (this) {

            while(cnt == 0) {
                wait();
            }
            Thread.sleep(5000);
            int elt = this.elts[cnt];
            cnt--;
            System.out.println("Consumed:" + elt);
            notify();

        }
    }
}

class Producer implements  Runnable {
    SharedQueue q;
    String name;
    int cnt = 0;
    Producer(SharedQueue q, String name) {
        this.q = q;
        this.name = name;
        Thread t= new Thread(this);
        t.start();
    }



    @Override
    public void run() {
        for(int i=0; i< 10 ;i++) {
            System.out.println("Producing "+ i +"yh time ");
            try {
                this.q.produce();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Producer completed " );

    }
}

class Consumer implements  Runnable{
    private String name;
    SharedQueue q;
    Consumer(SharedQueue q, String name) {
        this.name = name;
        this.q = q;
        Thread t= new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        try {
            for(int i=0; i< 10 ;i++) {
                System.out.println("Consuming "+ i +"yh time ");
                this.q.consume();
            }
        }catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Consumer completed " );


    }
}