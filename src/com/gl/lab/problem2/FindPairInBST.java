package com.gl.lab.problem2;

class Node {
    int key;
    Node left, right;

    Node(int data) {
        key = data;
        left = null;
        right = null;
    }
}

public class FindPairInBST {
    Node root;

    FindPairInBST() {
        root = null;
    }

    void insert(int key) {
        root = insertRecursively(root, key);
    }

    Node insertRecursively(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.key) {
            root.left = insertRecursively(root.left, data);
        } else if (data > root.key) {
            root.right = insertRecursively(root.right, data);
        }
        return root;
    }

    boolean isPairAvailable(Node root, Node temp, int sum) {
        if (temp == null)
            return false;
        else
            return search(root, temp, sum - temp.key) || isPairAvailable(root, temp.left, sum) || isPairAvailable(root, temp.right, sum);
    }

    boolean search(Node root, Node temp, int key) {
        if (root == null)
            return false;
        Node current = root;
        boolean flag = false;
        while (current != null && flag != true) {
            if (current.key == key && temp != current) {
                flag = true;
                System.out.println("Pair is (" + current.key + "," + temp.key + ")");
                return true;
            } else if (key < current.key)
                current = current.left;
            else
                current = current.right;
        }
        return flag;
    }

    public static void main(String[] args) {
        FindPairInBST findPairInBST = new FindPairInBST();
        /*
                   4
                /     \
              2        6
             / \      /  \
            1   3    5    7
        */
        findPairInBST.insert(4);
        findPairInBST.insert(2);
        findPairInBST.insert(6);
        findPairInBST.insert(1);
        findPairInBST.insert(3);
        findPairInBST.insert(5);
        findPairInBST.insert(7);

        int sum = 6;
        System.out.println("Sum = " + sum);
        if (findPairInBST.isPairAvailable(findPairInBST.root, findPairInBST.root, sum)) {

        } else
            System.out.println("nodes are not found.");
    }
}
