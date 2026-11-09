package lw04.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int cardCount = sc.nextInt();
        int[] cardValue = new int[cardCount];
        for (int i = 0; i < cardCount; i++) {
            cardValue[i] = sc.nextInt();
        }
        int targetCardValue = sc.nextInt();
        int[] targetCardValues = new int[targetCardValue];
        for (int i = 0; i < targetCardValue; i++) {
            targetCardValues[i] = sc.nextInt();
        }
        sc.close();

        // Selection sort (ascending)
        for (int i = 0; i < 2; i++) {
            int smallestValue = cardValue[i];
            int positionSmallestValue = i;
            for (int j = i; j < cardCount; j++) {
                if (cardValue[j] < smallestValue) {
                    smallestValue = cardValue[j];
                    positionSmallestValue = j;
                }
            }
            cardValue[positionSmallestValue] = cardValue[i];
            cardValue[i] = smallestValue;
        }

        for (int i : cardValue) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Linear search
        for (int target : targetCardValues) {
            boolean isFound = false;
            for (int i = 0; i < cardCount; i++) {
                if (cardValue[i] == target) {
                    System.out.println(target + ": FOUND at index " + i);
                    isFound = true;
                    break;
                }
            }
            if (!isFound)
                System.out.println(target + ": NOT FOUND");
        }

    }
}
