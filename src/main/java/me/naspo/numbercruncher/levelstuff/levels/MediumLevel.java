package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.Main;
import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.levelstuff.LevelManager;
import me.naspo.numbercruncher.levelstuff.enums.Level;
import me.naspo.numbercruncher.levelstuff.enums.Operator;

import java.util.TimerTask;

public class MediumLevel extends LevelStructure {

    public MediumLevel(LevelManager levelManager, AccountManager accountManager, Main game) {
        super(levelManager, accountManager, game);
    }

    @Override
    public void start() {
        strikes = 2;
        intro();
        Utils.wait(5000);
        super.countDown();

        //Practically infinite cycle of generating and answering questions until the player runs out of strikes.
        for (int question = 1; strikes > 0; question++) {
            //isolatedScannerThread.start();
            answered = false;
            System.out.println("Question #" + question);
            setupQuestion();
            qAndA();
        }

        gameOver();
    }

    @Override
    void intro() {
        System.out.println("Medium Level");
        System.out.println("Question Types: Multiplication (within times table range) along with addition or subtraction");
        System.out.println("(single or double digit).");
        System.out.println("Timer: 1 min/question");
        System.out.println("Strikes: 2");
    }

    @Override
    void setupQuestion() {
        //num1 and num2 are for multiplication. (Times table range).
        num1 = rand.nextInt(12) + 1;
        num2 = rand.nextInt(12) + 1;
        //num3 is for addition or subtraction. (Single or double digit).
        num3 = rand.nextInt(99) + 1;
        operator1 = Operator.MULTIPLICATION;
        //operator2 needs to be either addition or subtraction, so Level.EASY enum is passed in.
        operator2 = super.getRandomOperator(Level.EASY);
        answer = evaluateAnswer();
    }

    @Override
    int evaluateAnswer() {
        //temp int hold 1st part of the answer, the multiplication.
        int temp = 0;
        temp = (num1 * num2);

        //2nd part of equation, addition or subtraction.
        switch (operator2) {
            case ADDITION -> {
                return (temp + num3);
            }
            case SUBTRACTION -> {
                return (temp - num3);
            }
        }
        return 0;
    }

    @Override
    void qAndA() {
        System.out.println("What is (" + num1 + " " + operator1.asChar() + " " + num2 + ") "
        + operator2.asChar() + " " + num3 + "?");

        startTimer();

        //Get answer logic.
        //If they answered correctly...

        if (Utils.getInt() == answer) {
            answered = true;
            timer.cancel();
            System.out.println("You got that right! +10 points.");
            points = points + 10;
            return;
        }
        //If they answered incorrectly...
        answered = true;
        //timer.cancel();
        System.out.println("Incorrect! The correct answer is: " + answer + ".");
        strikes--;
        System.out.println("-1 strikes! Strikes remaining: " + strikes + ".");
    }


    private void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!(answered)) {
                    //skip the scanner
                    System.out.println("Time up! You're too slow this time.");
                    System.out.println("The correct answer was: " + answer + ".");
                    System.out.println("-1 strikes! Strikes remaining: " + strikes + ".");
                }
            }
        }, 5000);
    }

    @Override
    void gameOver() {
        System.out.println("You just used up your last strike. Game over!");

        //If they have a new high-score, display it and store it.
        if (points > accountManager.getSessionAccount().getEasyHighScore()) {
            accountManager.getSessionAccount().setMediumHighScore(points);
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
