package me.naspo.numbercruncher.menu.menus;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.datamanagement.DataManager;
import me.naspo.numbercruncher.menu.MenuManager;

public class PlayMenu extends Menu {

    private AccountManager accountManager;
    public PlayMenu(MenuManager menuManager, AccountManager accountManager) {
        super(menuManager);
        this.accountManager = accountManager;
    }


    public void display() {
        signIn();
    }

    private void signIn() {
        System.out.println("Are you new? Press 1 to create an account.");
        System.out.println("Already have an account? Press 2 to login.");

        switch (Utils.getInt(1, 2)) {
            //Create an account.
            case 1 -> {
                System.out.print("What would you like your username to be? ");
                accountManager.createAccount(scan.next());
            }
            //Login.
            case 2 -> {

            }
        }

    }
}
