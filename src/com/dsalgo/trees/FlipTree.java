package com.dsalgo.trees;

import java.util.LinkedList;

public class FlipTree {


    public static  void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(10);
        binaryTree.insert(2);
        binaryTree.insert(11);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(8);
        binaryTree.insert(9);
        binaryTree.printBFS(binaryTree);
        binaryTree = flipTree(binaryTree);
        binaryTree.printBFS(binaryTree);
    }

    private static BinaryTree flipTree(BinaryTree binaryTree) {
        Node root = binaryTree.root;
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

        return binaryTree;
    }
}
