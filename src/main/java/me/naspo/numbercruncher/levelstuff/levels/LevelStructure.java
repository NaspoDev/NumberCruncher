package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.levelstuff.LevelManager;
import me.naspo.numbercruncher.levelstuff.enums.Level;
import me.naspo.numbercruncher.levelstuff.enums.Operator;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

//Abstract Level class. Contains level class structure and other important methods.
public abstract class LevelStructure {

    protected final Scanner scan = new Scanner(System.in);
    protected Random rand = new Random();
    protected final Timer timer = new Timer();
    protected LevelManager levelManager;
    protected AccountManager accountManager;

    protected int strikes = 0;
    protected int points = 0;
    protected int num1 = 0;
    protected int num2 = 0;
    protected int num3 = 0;
    protected int num4 = 0;
    protected Operator operator = null;
    protected int answer = 0;

    //Used for countDown() method.
    private int currentCount = 3;

    LevelStructure(LevelManager levelManager, AccountManager accountManager) {
        this.levelManager = levelManager;
        this.accountManager = accountManager;
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
    //Game over logic. Displaying and saving stats, and closing the program.
    abstract void gameOver();

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
    protected Operator getRandomOperator(Level level) {
        //0 = "+"
        //1 = "-"
        //2 = "*"
        //3 = "/"

        //Random value (up to 3) to determine the operator to return.
        int val = 0;

        //Checking which level we are returning an operator for, and setting the bounds of val accordingly.
        switch (level) {
            case EASY -> val = rand.nextInt(2);
            case MEDIUM -> val = rand.nextInt(3);
            case HARD -> val = rand.nextInt(4);
        }

        //Determining which type of operator to return.
        switch (val) {
            case 0 -> {
                return Operator.ADDITION;
            }
            case 1 -> {
                return Operator.SUBTRACTION;
            }
            case 2 -> {
                return Operator.MULTIPLICATION;
            }
            case 3 -> {
                return Operator.DIVISION;
            }
        }
        return null;
    }
}