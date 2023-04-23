package com.gl.lab.problem2;

import java.util.HashSet;

public class FindPairInBST {

    static class Node {
        int key;
        Node left, right;
    }

    static Node NewNode(int data) {
        Node temp = new Node();
        temp.key = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    static Node insert(Node root, int data) {
        if (root == null)
            return NewNode(data);
        if (data < root.key)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

    static boolean checkPairRecursively(Node root, int sum, HashSet<Integer> set) {
        if (root == null)
            return false;
        if (checkPairRecursively(root.left, sum, set))
            return true;
        if (set.contains(sum - root.key)) {
            System.out.println("Pair is (" + (sum - root.key) + "," + root.key + ")");
            return true;
        } else
            set.add(root.key);
        return checkPairRecursively(root.right, sum, set);
    }

    static void checkPairInBST(Node root, int sum) {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!checkPairRecursively(root, sum, set))
            System.out.println("nodes are not found");
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 60);
        root = insert(root, 10);
        root = insert(root, 30);
        root = insert(root, 50);
        root = insert(root, 70);

        int sum = 130;
        System.out.println("Sum = " + sum);
        checkPairInBST(root, sum);
    }
}
