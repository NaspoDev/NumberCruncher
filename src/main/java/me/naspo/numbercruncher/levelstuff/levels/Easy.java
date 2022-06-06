package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.levelstuff.LevelManager;
import me.naspo.numbercruncher.levelstuff.enums.Levels;
import me.naspo.numbercruncher.levelstuff.enums.Operators;

public class Easy extends Level {

    Easy(LevelManager levelManager) {
        super(levelManager);
    }

    @Override
    public void start() {
        intro();
        Utils.wait(5000);
        super.countDown();
    }

    @Override
    void intro() {
        System.out.println("Easy Level");
        System.out.println("Question Types: Up to triple digit addition/subtraction with two numbers.");
        System.out.println("Timer: No");
        System.out.println("Strikes: 3");
    }

    @Override
    void setupQuestion() {
        num1 = rand.nextInt(999) + 1;
        num2 = rand.nextInt(999) + 1;
        operator = super.getRandomOperator(Levels.EASY);
        answer = evaluateAnswer();
    }


    @Override
    int evaluateAnswer() {
        if (operator == Operators.ADDITION) {
            return num1 + num2;
        } else if (operator == Operators.SUBTRACTION) {
            return num1 - num2;
        }
        return 0;
    }

    @Override
    void qAndA() {
        System.out.println("What is " + num1 + " " + operator);
    }

}
