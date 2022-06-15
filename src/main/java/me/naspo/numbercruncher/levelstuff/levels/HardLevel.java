package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.Main;
import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.levelstuff.LevelManager;
import me.naspo.numbercruncher.levelstuff.enums.Operator;

import java.util.Timer;
import java.util.TimerTask;

public class HardLevel extends LevelStructure {

    public HardLevel(LevelManager levelManager, AccountManager accountManager, Main game) {
        super(levelManager, accountManager, game);
    }

    @Override
    public void start() {
        strikes = 1;
        intro();
        Utils.wait(5000);
        super.countDown();

        //Practically infinite cycle of generating and answering questions until the player runs out of strikes.
        for (int question = 1; strikes > 0; question++) {
            outOfTime = false;
            System.out.println("Question #" + question);
            setupQuestion();
            qAndA();
        }

        gameOver();
    }

    @Override
    void intro() {
        System.out.println("Hard Level");
        System.out.println("Question Types: Multiplication (outside of times table range * single digit) + " +
                "(single|double|triple digit / single digit). ");
        System.out.println("Timer: 15 sec/question");
        System.out.println("Strikes: 1");
        System.out.println("Important Note: Always round down your answers!");
    }

    @Override
    void setupQuestion() {
        //num1 is outside of times table range (13-99).
        num1 = rand.nextInt(87) + 13;
        //num2 is single digit (1-9).
        num2 = rand.nextInt(9) + 1;
        //num3 is up to triple digit (1-999).
        num3 = rand.nextInt(999) + 1;
        //num4 is single digit (1-9).
        num4 = rand.nextInt(9) + 1;
        operator1 = Operator.MULTIPLICATION;
        operator2 = Operator.ADDITION;
        operator3 = Operator.DIVISION;
        answer = evaluateAnswer();
    }

    @Override
    int evaluateAnswer() {
        return (num1 * num2) + (num3 / num4);
    }

    @Override
    void qAndA() {
        System.out.println("What is (" + num1 + " " + operator1.asChar() + " " + num2 + ") " + operator2.asChar()
                + " (" + num3 + " " + operator3.asChar() + " " + num4 + ")?");

        startTimer();

        // --- Get answer logic ---

        //If they answered correctly...
        if (Utils.getInt() == answer) {
            timer.cancel();
            //If they ran out of time.
            if (outOfTime) {
                System.out.println("You got that right, but you ran out of time!");
                strikes--;
                System.out.println("-1 strikes! Strikes remaining: " + strikes + ".");
                //Otherwise
            } else {
                System.out.println("You got that right! +10 points.");
                points = points + 10;
            }
            return;
        }

        timer.cancel();
        //If they answered incorrectly...
        //And if they were out of time.
        if (outOfTime) {
            System.out.println("Incorrect! The correct answer is: " + answer + ".");
            System.out.println("You also ran out of time on that question.");
            strikes--;
            System.out.println("-1 strikes! Strikes remaining: " + strikes + ".");
            //Otherwise
        } else {
            System.out.println("Incorrect! The correct answer is: " + answer + ".");
            strikes--;
            System.out.println("-1 strikes! Strikes remaining: " + strikes + ".");
        }
    }

    private void startTimer() {
        //Re-initializing timer because you cannot re-schedule a task on a cancelled timer.
        timer = new Timer();
        //Schedule the timer task.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                outOfTime = true;
            }
        }, 15000);
    }

    @Override
    void gameOver() {
        System.out.println("You just used up your last strike. Game over!");

        //If they have a new high-score, display it and store it.
        if (points > accountManager.getSessionAccount().getHardHighScore()) {
            accountManager.getSessionAccount().setHardHighScore(points);
            System.out.println("New high-score! Score: " + points + " points.");
            //Otherwise not a high-score, just display points.
        } else {
            System.out.println("Your score: " + points + " points");
        }

        System.out.println("Thanks for playing!");
        //End the game.
        game.end();
    }
}
