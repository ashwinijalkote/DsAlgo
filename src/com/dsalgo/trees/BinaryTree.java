package com.dsalgo.trees;


import java.util.*;

class Node {
    int data;
    int hd;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    Node root;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node temp = root;
        Node temp1= temp;
        while (temp != null) {
            temp1= temp;
            if (data < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        temp = new Node(data);
        if (temp.data < temp1.data ) {
            temp1.left = temp;

        } else {
            temp1.right = temp;
        }

    }

    public void printInorder(Node rootOfTree) {
        Node temp = rootOfTree;
            if (temp == null) return;
            printInorder(rootOfTree.left);
            System.out.print(temp.data + "\t");
            printInorder(rootOfTree.right);

    }

    public void printInorderIterative(Node rootOfTree) {
        Stack<Node> s1 = new Stack();
        Node temp = rootOfTree;
        Node temp1;

        while(true) {
            while (temp != null) {
                s1.push(temp);
                temp = temp.left;
            }
            if (s1.isEmpty()) return;
            temp1 = s1.pop();
            System.out.print(temp1.data + "\t");
            temp = temp1.right;
        }

    }

    public void bottomView(Node rootOfTree) {
        Node temp = rootOfTree;
        Queue<Node> q1 = new LinkedList<>();
        TreeMap<Integer, Node> treeMap = new TreeMap();

        temp.hd = 0;
        q1.add(temp);
        Node temp1;
        while(!q1.isEmpty()) {
            temp1 = q1.remove();
            treeMap.put(temp1.hd, temp1);
            if (temp1.left != null) {
                temp1.left.hd = temp1.hd -1;
                q1.add(temp1.left);
            }
            if (temp1.right != null) {
                temp1.right.hd = temp1.hd + 1;
                q1.add(temp1.right);
            }

        }

        for(Map.Entry<Integer, Node>  entry: treeMap.entrySet()) {
            System.out.print(entry.getValue().data + "\t");
        }
    }
}

class main {
    public static void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(15);
        binaryTree.insert(5);
        System.out.println("Inorder traversal");
        binaryTree.printInorder(binaryTree.root);

        System.out.println("\nInorder traversal");

        binaryTree.printInorderIterative(binaryTree.root);
        System.out.println("\nBottom view of tree");

        binaryTree.bottomView(binaryTree.root);

    }
}