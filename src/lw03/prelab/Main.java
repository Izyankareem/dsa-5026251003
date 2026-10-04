package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static void problemOne() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> storedSongs = new ArrayList<>();
        int songCount = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String song;
            String operationType = parts[0];

            if (operationType.equals("ADD")) {
                // From the line, we get the string from the forth index for skipping the
                // operation type
                song = line.substring(4);
                // If the song not in the list, add the song counter
                if (!storedSongs.contains(song))
                    songCount++;
                storedSongs.add(song);
            }

            if (operationType.equals("INSERT")) {
                int index = Integer.parseInt(parts[1]);
                song = line.substring(9);
                if (!storedSongs.contains(song))
                    songCount++;
                storedSongs.add(index, song);
            }

            if (operationType.equals("REMOVE")) {
                song = line.substring(7);
                storedSongs.remove(song);
            }
        }

        System.out.println("=== Problem 1 ===");
        System.out.println("Total songs: " + songCount);
        for (int i = 1; i <= storedSongs.size(); i++) {
            System.out.println(i + ": " + storedSongs.get(i - 1));
        }
    }

    static void problemTwo() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participantLists = new LinkedHashSet<>();
        int countDupeParticipant = 0;
        while (sc.hasNext()) {
            boolean isAdded = participantLists.add(sc.next());
            if (!isAdded)
                countDupeParticipant++;
        }
        System.out.println("=== Problem 2 ===");
        System.out.println("Unique participants: " + participantLists.size());
        int i = 1;
        for (String participant : participantLists) {
            System.out.println(i + ". " + participant);
            i++;
        }
        System.out.println("Duplicate registrations: " + countDupeParticipant);
    }

    static void problemThree() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventoryList = new LinkedHashMap<>();
        int failedOperation = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String operationType = parts[0];
            String product = parts[1];
            int amount = Integer.parseInt(parts[2]);

            if (operationType.equals("ADD"))
                inventoryList.merge(product, amount, Integer::sum);

            if (operationType.equals("SELL")) {
                if (inventoryList.containsKey(product) && inventoryList.get(product) >= amount) {
                    inventoryList.merge(product, -amount, Integer::sum);
                } else {
                    failedOperation++;
                }
            }
        }

        System.out.println("=== Problem 3 ===");
        for (String key : inventoryList.keySet()) {
            System.out.println(key + ": " + inventoryList.get(key));
        }
        System.out.println("Failed sales: " + failedOperation);
    }

    public static void main(String[] args) {
        problemOne();
        System.out.println();
        problemTwo();
        System.out.println();
        problemThree();
        System.out.println( );
    }
}
