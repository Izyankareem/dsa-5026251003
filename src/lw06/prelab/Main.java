package lw06.prelab;

import java.util.Scanner;

public class Main {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data, null, null);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        } else if (target > root.data) {
            return search(root.right, target);
        } else {
            return search(root.left, target);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        Node root = null;
        for (int i = 0; i < 7; i++) {
            root = insert(root, sc.nextInt());
        }

        int targetValue = sc.nextInt();
        sc.close();

        System.out.print("Preorder: ");
        preorder(root);

        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);

        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);

        System.out.println();

        System.out.println("Search " + targetValue + " : " + search(root, targetValue));
    }
}
