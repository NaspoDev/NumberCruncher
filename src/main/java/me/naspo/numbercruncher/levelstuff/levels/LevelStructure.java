package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.Main;
import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.levelstuff.LevelManager;
import me.naspo.numbercruncher.levelstuff.enums.Operator;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

//Abstract Level class. Contains level class structure and other important methods and objects.
public abstract class LevelStructure {

    protected Random rand = new Random();
    protected Timer timer = new Timer();
    protected LevelManager levelManager;
    protected AccountManager accountManager;
    protected Main game;

    protected int strikes = 0;
    protected int points = 0;
    protected int num1 = 0;
    protected int num2 = 0;
    protected int num3 = 0;
    protected int num4 = 0;
    protected Operator operator1 = null;
    protected Operator operator2 = null;
    protected Operator operator3 = null;
    protected int answer = 0;
    protected boolean outOfTime = false;

    //Used for countDown() method.
    private int currentCount = 3;

    LevelStructure(LevelManager levelManager, AccountManager accountManager, Main game) {
        this.levelManager = levelManager;
        this.accountManager = accountManager;
        this.game = game;
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

        Utils.wait(1000);
        System.out.println("3");
        Utils.wait(1000);
        System.out.println("2");
        Utils.wait(1000);
        System.out.println("1");
        Utils.wait(1000);
    }

    //Monitors and modifies currentCount object used in countDown() method.
    private int count() {
        if (currentCount == 1) {
            timer.cancel();
        }
        return currentCount--;
    }

    //Returns a random operator of value '+' or '-'.
    protected Operator getRandomOperator() {
        //0 = "+"
        //1 = "-"

        //Random value (up to 1) to determine the operator to return.
        int val = 0;
        val = rand.nextInt(2);

        //Determining which type of operator to return.
        switch (val) {
            case 0 -> {
                return Operator.ADDITION;
            }
            case 1 -> {
                return Operator.SUBTRACTION;
            }
        }
        return null;
    }
}
