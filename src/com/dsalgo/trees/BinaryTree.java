package com.dsalgo.trees;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Math.min;

class BNode {
    int data;
    BNode left, right;

    BNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public int getData() {
        return data;
    }
}

class BinaryTree {

    BNode root;


    public void printTree(){

        BNode temp = this.root;
        Stack<BNode> s1= new Stack<>();
        while(true) {
            while(temp != null) {
                s1.push(temp);
                System.out.println(temp.data);
                temp = temp.left;
            }
            if (s1.isEmpty()) return;
            temp = s1.pop();
            temp = temp.right;
        }
    }
    class StackNode {
        BNode node;
        boolean bothVisited= false;
        StackNode(BNode node) {
            this.node = node;
        }

        public boolean isBothVisited() {
            return bothVisited;
        }

        public void setBothVisited(boolean bothVisited) {
            this.bothVisited = bothVisited;
        }

        public BNode getNode() {
            return node;
        }
    }

    public int[] findPath(int data) {
        BNode temp = this.root;
        Stack<StackNode> s1 = new Stack<>();



        while(true) {

            while(temp != null) {
                s1.push(new StackNode(temp));
                if (temp.data == data) {
                    return getPathFromStack(s1);
                }
                temp = temp.left;
            }
            if (s1.isEmpty()) {
                return getPathFromStack(s1);
            }
             StackNode snode = s1.pop();
            temp = snode.getNode();
            if (snode.isBothVisited() == true) {
                while(snode.isBothVisited() == true) {
                    if (s1.isEmpty()) return getPathFromStack(s1);
                    snode = s1.pop();
                    temp = snode.getNode();
                }
            }
                snode.setBothVisited(true);
                s1.push(snode);


            temp = temp.right;

        }

    }


    public void zigzag(BNode root ){
        System.out.println(root.data);
        if(root.right == null || root.left == null) {
            return;
        }
        while(root.right != null) {
            BNode left = root.left;
            zigzag(left);
            BNode right = root.right;
            zigzag(right);

        }



    }

    public int findLCA(int data1, int data2) {

        int [] path1 = findPath(data1);
        int [] path2 = findPath(data2);

        Arrays.stream(path1).forEach(System.out::print);
        System.out.println();
        Arrays.stream(path2).forEach(System.out::print);
        System.out.print("\nLCA: " );
        int i =0;
        int prev = -1;
        while (i < min(path1.length, path2.length)) {
            if (path1[i] == path2[i]) {
                prev = path1[i];
            } else {
                return prev;
            }
            i++;
        }
        return prev;
    }
    private int[] getPathFromStack(Stack<StackNode> s1) {
        if(s1 == null || s1.isEmpty()) {
            return new int[]{};
        }

         return s1.stream().mapToInt(e -> e.getNode().getData()).toArray();
    }

    public static void main(String args[])  {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new BNode(10);
        binaryTree.root.left = new BNode(20);
        binaryTree.root.left.right = new BNode(50);
        binaryTree.root.left.left = new BNode(30);
        binaryTree.root.left.left.left = new BNode(40);
        binaryTree.root.right = new BNode(35);
        binaryTree.root.right.left = new BNode(80);
        binaryTree.root.right.left.right = new BNode(90);

        binaryTree.printTree();

        Arrays.stream(binaryTree.findPath(30)).forEach(System.out::print);
        System.out.println();
        //binaryTree.printTree();

       //Arrays.stream(binaryTree.findPath(40)).forEach(System.out::print);
        System.out.println();
       // Arrays.stream(binaryTree.findPath(50)).forEach(System.out::print);
        System.out.println();
        //Arrays.stream(binaryTree.findPath(80)).forEach(System.out::print);
        System.out.println();
       // Arrays.stream(binaryTree.findPath(90)).forEach(System.out::print);

       // System.out.println(binaryTree.findLCA(30, 80));
       // System.out.println(binaryTree.findLCA(30, 50));
       // System.out.println(binaryTree.findLCA(35, 90));
        //System.out.println(binaryTree.findLCA(100, 90));

        binaryTree.zigzag(binaryTree.root);
    }
}


