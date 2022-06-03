package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.levelstuff.LevelManager;

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

    //Display level intro.
    @Override
    void intro() {
        System.out.println("Easy Level");
        System.out.println("Question Types: Up to triple digit addition.");
        System.out.println("Timer: No");
        System.out.println("Strikes: 3");
    }

    @Override
    void qAndA() {

    }


}
