package me.naspo.numbercruncher;

import java.util.Scanner;

public class Utils {

    private static final Scanner scan = new Scanner(System.in);
    private static boolean loop = true;

    public static int getInt() {
        do {
            try {
                return scan.nextInt();
            } catch (Exception e) {
                System.out.print("Please enter a valid integer: ");
            }
        } while (loop);

        return 0;
    }
}
