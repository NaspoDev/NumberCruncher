package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.levelstuff.LevelManager;
import me.naspo.numbercruncher.levelstuff.enums.Level;

/*
Easy Level
Question Types: Up to triple digit addition/subtraction with two numbers.
Timer: No
Strikes: 3
*/
public class EasyLevel extends LevelStructure {

    public EasyLevel(LevelManager levelManager, AccountManager accountManager) {
        super(levelManager, accountManager);
    }

    @Override
    public void start() {
        strikes = 3;
        intro();
        Utils.wait(5000);
        super.countDown();

        //Practically infinite cycle of generating and answering questions until the player runs out of strikes.
        for (int question = 1; strikes > 0; question++) {
            System.out.println("Question #" + question);
            setupQuestion();
            qAndA();
        }

        gameOver();
    }

    @Override
    void intro() {
        System.out.println("Easy Level");
        System.out.println("Question Types: Up to triple digit addition/subtraction with two numbers.");
        System.out.println("Timer: No");
        System.out.println("Strikes: 3");
    }

    //Getting two numbers, one random operator, and storing the answer.
    @Override
    void setupQuestion() {
        num1 = rand.nextInt(999) + 1;
        num2 = rand.nextInt(999) + 1;
        operator1 = super.getRandomOperator(Level.EASY);
        answer = evaluateAnswer();
    }

    @Override
    int evaluateAnswer() {
        switch (operator1) {
            case ADDITION -> {
                return num1 + num2;
            }
            case SUBTRACTION -> {
                return num1 - num2;
            }
        }
        return 0;
    }

    @Override
    void qAndA() {
        System.out.println("What is " + num1 + " " + operator1.asChar() + " " + num2 + "?");

        //If they answered correctly...
        if (Utils.getInt() == answer) {
            System.out.println("You got that right! +10 points.");
            points = points + 10;
            return;
        }
        //If they answered incorrectly...
        System.out.println("Incorrect! The correct answer is: " + answer + ".");
        strikes--;
        System.out.println("-1 strikes! Strikes remaining: " + strikes + ".");
    }

    @Override
    void gameOver() {
        System.out.println("You just used up your last strike. Game over!");

        //If they have a new high-score, display it and store it.
        if (points > accountManager.getSessionAccount().getEasyHighScore()) {
            System.out.println("New high-score! Score: " + points + " points.");
            //Otherwise not a high-score, just display points.
        } else {
            System.out.println("Your score: " + points + " points");
        }

        System.out.println("Thanks for playing!");
        //Close the program.
        System.exit(0);
    }

}
