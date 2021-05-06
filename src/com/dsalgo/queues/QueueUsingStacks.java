
package com.dsalgo.queues;

import java.util.Stack;

class QueueUsingStacks<E> {

    Stack<E> s1;
    Stack<E> s2;

    QueueUsingStacks() {
        s1= new Stack<>();
        s2= new Stack<>();
    }

    public void enqueue(E elt) {
       while (!s2.isEmpty()) {
           E eltPoped = s2.pop();
           s1.push(eltPoped);
       //    System.out.println("Elt popped from s2" + eltPoped);
       }
       s1.push(elt);
    }


    public E dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("queue empty");
        }
        while(!s1.isEmpty()) {
            E eltPushed = s1.pop();
            s2.push(eltPushed);
        //    System.out.println("Elt pushed tp s2" + eltPushed);
        }
        return s2.pop();
    }

}

class main {
    public static void main(String args[]) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
