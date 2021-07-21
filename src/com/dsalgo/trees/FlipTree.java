package com.dsalgo.trees;

import java.util.LinkedList;

public class FlipTree {


    public static  void main(String args[]) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(10);
        binarySearchTree.insert(2);
        binarySearchTree.insert(11);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(9);
        binarySearchTree.printBFS(binarySearchTree);
        binarySearchTree = flipTree(binarySearchTree);
        binarySearchTree.printBFS(binarySearchTree);
    }

    private static BinarySearchTree flipTree(BinarySearchTree binarySearchTree) {
        Node root = binarySearchTree.root;
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            Node parent = queue.remove();
            if (parent == null) {
                continue;
            }
            queue.add(parent.left);
            queue.add(parent.right);
            Node temp = parent.left;
            parent.left = parent.right;
            parent.right = temp;
        }

        return binarySearchTree;
    }
}
