package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        BinarySearchTree bst = new BinarySearchTree();

        String rawInput = sc.nextLine();
        String[] input = rawInput.split(" ");

        for (String dataString : input) {
            int data = Integer.parseInt(dataString);
            bst.insert(data);
        }

        int target = sc.nextInt();
        sc.close();

        System.out.print("Preorder : ");
        bst.preOrder();
        System.out.print("Inorder : ");
        bst.inOrder();
        System.out.print("Postorder : ");
        bst.postOrder();
        System.out.println("Search " + target + " : " + bst.search(target));
        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());

    }
}
