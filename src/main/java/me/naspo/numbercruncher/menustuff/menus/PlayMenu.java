package me.naspo.numbercruncher.menustuff.menus;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.levelstuff.LevelManager;
import me.naspo.numbercruncher.menustuff.MenuManager;

public class PlayMenu extends MenuStructure {

    private AccountManager accountManager;
    private LevelManager levelManager;

    public PlayMenu(MenuManager menuManager, AccountManager accountManager, LevelManager levelManager) {
        super(menuManager);
        this.accountManager = accountManager;
        this.levelManager = levelManager;
    }

    public void display() {
        accountManager.signIn();
        selectDifficulty();
    }

    private void selectDifficulty() {
        System.out.println("1 - EASY | 2 - MEDIUM | 3 - HARD");
        System.out.println("Select a Difficulty");
        System.out.println("Or enter \"4\" to go back...");

        switch (Utils.getInt(1, 4)) {
            //Easy
            case 1 -> levelManager.startEasyLevel();
            //Medium
            case 2 -> levelManager.startMediumLevel();
            //Hard
            case 3 -> levelManager.startHardLevel();
            //Go back to welcome screen.
            case 4 -> menuManager.getWelcomeScreen().display();
        }
    }
}
