package me.naspo.numbercruncher.levelstuff.levels;

import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.levelstuff.LevelManager;

public class HardLevel extends LevelStructure {

    public HardLevel(LevelManager levelManager, AccountManager accountManager) {
        super(levelManager, accountManager);
    }

    @Override
    public void start() {

    }

    @Override
    void intro() {

    }

    @Override
    void setupQuestion() {

    }

    @Override
    int evaluateAnswer() {
        return 0;
    }

    @Override
    void qAndA() {

    }

    @Override
    void gameOver() {

    }
}