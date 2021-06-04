package com.dsalgo.multithreading;

public class PrintEvenOddInSqeuence {

    public static void main(String args[]) {
        Print print = new Print();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int times =0;
                while(times< 10) {
                    print.printEven();
                    times++;
                }
            }
        }

        );
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int times =0;
                while(times < 10) {
                    print.printOdd();
                    times++;
                }
            }
        }
        );
        t1.start();
        t2.start();
    }
}

class Print {
    Integer cnt = 1;

    public void printEven() {

        synchronized (this) {
            while (cnt % 2 != 0) {
                try {
                    System.out.println("Thread Even" + Thread.currentThread().getName() + " waiting....");
                    wait();
                } catch (Exception e) {

                }
            }
            System.out.println("Thread Even" + Thread.currentThread().getName() + " -> " + cnt);
            cnt++;
            notify();
        }

    }

    public void printOdd() {
        synchronized (this) {
            while (cnt % 2 == 0) {
                try {
                    System.out.println("Thread Odd" + Thread.currentThread().getName() + " waiting....");
                    wait();
                } catch (Exception e) {

                }
            }
            System.out.println("Thread Odd" + Thread.currentThread().getName() + " -> " + cnt);
            cnt++;

            notify();
        }

    }

}