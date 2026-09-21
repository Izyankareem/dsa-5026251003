package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int count = sc.nextInt();

        Rental[] rentalList = new Rental[count];
        int[] unitDetail = new int[count];
        for (int i = 0; i < count; i++) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            // int unit = sc.nextInt();
            unitDetail[i] = sc.nextInt();

            if (type.equalsIgnoreCase("laptop")) {
                rentalList[i] = new LaptopRental(id, days);
            } else if (type.equalsIgnoreCase("projector")){
                rentalList[i] = new ProjectorRental(id, days);
            }
        }
        sc.close();

        for (int i = 0; i < count; i++) {
            Rental item = rentalList[i];
            System.out.println(item.summary(unitDetail[i]));
        }
    }
}
