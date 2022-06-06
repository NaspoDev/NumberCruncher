package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.levelstuff.LevelManager;
import me.naspo.numbercruncher.levelstuff.enums.Levels;
import me.naspo.numbercruncher.levelstuff.enums.Operators;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Level {

    protected final Scanner scan = new Scanner(System.in);
    protected Random rand = new Random();
    protected final Timer timer = new Timer();
    protected LevelManager levelManager;

    protected int num1 = 0;
    protected int num2 = 0;
    protected int num3 = 0;
    protected int num4 = 0;
    Enum<Operators> operator = null;
    protected int answer = 0;

    private int currentCount = 3;

    Level(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    //Called to start the level. Operation management method.
    public abstract void start();
    //Displays level intro.
    abstract void intro();
    //Initialize numbers, operators, and answer for the current question.
    abstract void setupQuestion();
    //Logic for evaluating the correct answer.
    abstract int evaluateAnswer();
    //Creating and displaying a question, and receiving an answer.
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

    //Returns a random operator. (Takes what operators to return based on enum level).
    protected Enum<Operators> getRandomOperator(Enum<Levels> level) {
        //0 = "+"
        //1 = "-"
        //2 = "*"
        //3 = "/"

        //Random value (up to 3) to determine the operator to return.
        int val = 0;

        //Checking which level we are returning an operator for, and setting the bounds of val accordingly.
        if (level == Levels.EASY) {
            val = rand.nextInt(2);
        } else if (level == Levels.MEDIUM) {
            val = rand.nextInt(3);
        } else if (level == Levels.HARD) {
            val = rand.nextInt(4);
        }

        //Determining which type of operator to return.
        switch (val) {
            case 0 -> {
                return Operators.ADDITION;
            }
            case 1 -> {
                return Operators.SUBTRACTION;
            }
            case 2 -> {
                return Operators.MULTIPLICATION;
            }
            case 3 -> {
                return Operators.DIVISION;
            }
        }
        return null;
    }
}
