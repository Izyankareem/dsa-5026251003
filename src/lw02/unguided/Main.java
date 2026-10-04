package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> bookStocks = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedRequests = new Stack<>();

        // String[] stockKalkulus = { "Kalkulus", "2" };
        // String[] stockFisika = { "Fisika", "1" };
        // String[] stockStatistika = { "Statistika", "2" };
        // bookStocks.add(stockKalkulus);
        // bookStocks.add(stockFisika);
        // bookStocks.add(stockStatistika);

        String[][] bookStockLists = { { "Kalkulus", "2" }, { "Fisika", "1" }, { "Statistika", "2" } };
        for (String[] bookStock : bookStockLists) {
            bookStocks.add(bookStock);
        }

        while (sc.hasNext()) {
            String[] request = new String[2];
            request[0] = sc.next();
            request[1] = sc.next();

            requests.add(request);
        }

        sc.close();

        queue.addAll(requests);
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            String[] request = queue.poll();
            String name = request[0];
            String requestedBook = request[1];

            String[] memberData = null;
            for (String[] member : members) {
                if (member[0].equals(name)) {
                    memberData = member;
                }
            }

            if (memberData == null) {
                String[] newMember = { name, "0" };
                members.add(newMember);
                memberData = newMember;
            }

            String[] bookData = null;
            for (String[] book : bookStocks) {
                if (book[0].equals(requestedBook)) {
                    bookData = book;
                }
            }

            int memberLimit = Integer.parseInt(memberData[1]);
            int bookStock = Integer.parseInt(bookData[1]);
            if (memberLimit < 2 && bookStock > 0) {
                memberData[1] = Integer.toString(memberLimit + 1);
                bookData[1] = Integer.toString(bookStock - 1);
                // Return if successfull
                queue.offer(request);
            } else {
                failedRequests.push(request);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        while (!queue.isEmpty()) {
            String[] successfullRequest = queue.poll();
            System.out.println(successfullRequest[0] + " " + successfullRequest[1]);
        }

        System.out.println("\n=== Remaining Book Stock ===");
        for (String[] bookStock : bookStocks) {
            System.out.println(bookStock[0] + " : " + bookStock[1]);
        }

        System.out.println("\n=== Failed Requests ===");
        while (!failedRequests.isEmpty()) {
            String[] failedRequest = failedRequests.pop();
            System.out.println(failedRequest[0] + " " + failedRequest[1]);
        }
    }
}
