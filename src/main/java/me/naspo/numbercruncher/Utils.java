package me.naspo.numbercruncher;

import java.util.Scanner;

public class Utils {

    private static final Scanner scan = new Scanner(System.in);
    private static boolean loop = true;

    //Gets and returns an integer input.
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

    //Removes filetype extension from file name.
    public static String removeExtension(String name) {
        return name.substring(0, name.lastIndexOf('.'));
    }
}
