package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.levelstuff.LevelManager;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Level {

    protected final Scanner scan = new Scanner(System.in);
    protected final Timer timer = new Timer();
    protected LevelManager levelManager;

    private int currentCount = 3;

    Level(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    public abstract void start();
    abstract void intro();
    abstract void qAndA();

    //Displays a countdown from 3. Used to countdown level start.
    protected void countDown() {
        System.out.println("Starting in...");

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(count());
            }
        }, 1000, 1000);
    }

    //Monitors and modifies currentCount object used in countDown() method.
    private int count() {
        if (currentCount == 1) {
            timer.cancel();
        }
        return currentCount--;
    }
}
