package me.naspo.numbercruncher;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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

    //Gets and returns an integer input with a filter on the input.
    public static int getInt(int rangeLowest, int rangeHighest) {
        do {
            try {
                int input = scan.nextInt();
                if (input >= rangeLowest && input <= rangeHighest) {
                    return input;
                } else {
                    System.out.print("Please enter a valid input: ");
                }
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

    //Delays for a specified amount of time (ms).
    public static void wait(int milliseconds) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            }
        }, milliseconds);
    }
}
