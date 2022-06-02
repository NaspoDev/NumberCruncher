package me.naspo.numbercruncher.menu.menus;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.menu.MenuManager;

public class PlayMenu extends Menu {

    private AccountManager accountManager;
    public PlayMenu(MenuManager menuManager, AccountManager accountManager) {
        super(menuManager);
        this.accountManager = accountManager;
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
            case 1 -> //send them to easy
            //Medium
            case 2 -> //send them to medium
            //Hard
            case 3 -> //send them to hard
            //Go back to welcome screen.
            case 4 -> menuManager.getWelcomeScreen().display();
        }
    }
}
