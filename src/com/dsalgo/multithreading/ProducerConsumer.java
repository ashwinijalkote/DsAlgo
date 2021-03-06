package com.dsalgo.multithreading;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

class ProducerConsumer {

    public static void main(String args[]) {

        SharedQueue q = new SharedQueue();
        Producer  producer1= new Producer(q, "producer1");
        Producer  producer2= new Producer(q, "producer2");
      //  Producer  producer2= new Producer(q, "producer1");
        Consumer  consumer1= new Consumer(q, "consumer1");
        Consumer  consumer2= new Consumer(q, "consumer2");
        //Consumer  consumer2= new Consumer(q, "consumer1");

    }
}

class SharedQueue {
    int elts[];
    private static int MAX_CAPACITY = 5;


    int cnt=0;
    SharedQueue() {
        elts = new int[MAX_CAPACITY];
    }

    public void  produce() throws InterruptedException {
        synchronized(this) {
            while(cnt == MAX_CAPACITY -1) {
                wait();
            }
            this.elts[cnt] = cnt++;
            System.out.println(Thread.currentThread().getName() + " Produced:" + this.elts[cnt - 1]);
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
            System.out.println(Thread.currentThread().getName() + " Consumed:" + elt);
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
        for(int i=0; i< 5 ;i++) {
            //System.out.println("Producing "+ i +"yh time ");
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
            for(int i=0; i< 5 ;i++) {
               // System.out.println("Consuming "+ i +"yh time ");
                this.q.consume();
            }
        }catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Consumer completed " );


    }
}