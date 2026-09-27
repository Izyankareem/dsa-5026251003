package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        LinkedList<String[]> allTransactions = new LinkedList<>();
        LinkedList<String[]> customerList = new LinkedList<>();

        while (sc.hasNext()) {
            String nama = sc.next();
            String action = sc.next();
            int intAmount = sc.nextInt();
            // Convert integer to string
            String amount = intAmount + "";

            String[] transaction = { nama, action, amount };
            allTransactions.add(transaction);

            boolean exist = false;
            for (String[] cust : customerList) {
                if (cust[0].equals(nama)) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                String[] newCust = { nama, "0" };
                customerList.add(newCust);
            }
        }

        sc.close();

        // Make queue and stack for storing transactions
        Queue<String[]> transactions = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();

        // Move from linkedlist to queue
        for (String[] trx : allTransactions) {
            transactions.offer(trx);
        }

        while (!transactions.isEmpty()) {
            // Get and remove the first item from the queue
            String[] trx = transactions.poll();

            for (String[] cust : customerList) {
                // Check which customer is doing action
                if (cust[0].equalsIgnoreCase(trx[0])) {
                    // Store the balance and amount into integer (convert from string)
                    int balance = Integer.parseInt(cust[1]);
                    int amount = Integer.parseInt(trx[2]);

                    // Check transaction type
                    if (trx[1].equalsIgnoreCase("deposit")) {
                        balance += amount;
                        cust[1] = String.valueOf(balance);
                    } else {
                        // Transaction type: withdraw
                        if (balance >= amount) {
                            balance -= amount;
                            cust[1] = String.valueOf(balance);
                        } else {
                            // Push to stack if the transaction failed (balance < amount)
                            failedTransactions.push(trx);
                        }
                    }

                    // If already match, there is no need to go to next cust
                    break;
                }
            }
        }

        // Print all transactoins
        System.out.println("=== Final Balances ===");

        for (String[] customer : customerList) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        // Print failed transactions
        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!failedTransactions.isEmpty()) {
            String[] failed = failedTransactions.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }

    }
}
