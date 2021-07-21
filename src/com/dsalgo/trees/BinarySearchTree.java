package com.dsalgo.trees;


import java.util.*;

class Node {
    int data;
    int hd;
    Node left, right, parent;

    Node(int data) {
        this.data = data;
    }
}

class BinarySearchTree {
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
        temp.parent = temp1;
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
            System.out.print(temp.data + ":" +  (temp.parent != null ? temp.parent.data: "") + "\t");
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

    public void printBFS(BinarySearchTree binarySearchTree) {
        Node root = binarySearchTree.root;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.println();
        while(!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp == null) continue;
            System.out.print(temp.data + "\t");
            queue.add(temp.left);
            queue.add(temp.right);
        }
    }

    public void LCA(Node root, int p, int q) {
        Node temp = root;
        Node tempP, tempQ;
        Stack<Node> s1 = new Stack();
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
}

class main {
    public static void main(String args[]) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(20);
        binarySearchTree.insert(15);
        binarySearchTree.insert(5);
        System.out.println("Inorder traversal");
        binarySearchTree.printInorder(binarySearchTree.root);

        System.out.println("\nInorder traversal");

        binarySearchTree.printInorderIterative(binarySearchTree.root);
        System.out.println("\nBottom view of tree");

        binarySearchTree.bottomView(binarySearchTree.root);

    }
}