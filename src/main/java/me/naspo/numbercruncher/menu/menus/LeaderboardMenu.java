package me.naspo.numbercruncher.menu.menus;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.datamanagement.Account;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.menu.MenuManager;

public class LeaderboardMenu extends Menu {

    private AccountManager accountManager;
    public LeaderboardMenu(MenuManager menuManager, AccountManager accountManager) {
        super(menuManager);
        this.accountManager = accountManager;
    }

    //Displays main leaderboard screen and prompts the user to choose a leaderboard.
    @Override
    public void display() {
        System.out.println("The LeaderBoard");
        System.out.println("1 - Easy Leaderboard | 2 - Medium Leaderboard | 3 - Hard Leaderboard");
        System.out.println("Or enter \"4\" to go back...");

        switch (Utils.getInt(1, 4)) {
            //Easy Leaderboard
            case 1 -> easyLeaderboard();
            //Medium Leaderboard
            case 2 -> mediumLeaderboard();
            //Hard Leaderboard
            case 3 -> hardLeaderboard();
            //Go back to welcome screen.
            case 4 -> menuManager.getWelcomeScreen().display();
        }
    }

    private void easyLeaderboard() {
        System.out.println("Easy Leaderboard");
        System.out.format("%-10s %10s %n", "Username", "High-score");
        for (Account account : accountManager.getAccountList()) {
            System.out.format("%-10s %10s %n", account.getUsername(), account.getEasyHighScore());
        }
        backToLeaderboard();
    }

    private void mediumLeaderboard() {
        System.out.println("Medium Leaderboard");
        System.out.format("%-10s %10s %n", "Username", "High-score");
        for (Account account : accountManager.getAccountList()) {
            System.out.format("%-10s %10s %n", account.getUsername(), account.getMediumHighScore());
        }
        backToLeaderboard();
    }

    private void hardLeaderboard() {
        System.out.println("Medium Leaderboard");
        System.out.format("%-10s %10s %n", "Username", "High-score");
        for (Account account : accountManager.getAccountList()) {
            System.out.format("%-10s %10s %n", account.getUsername(), account.getMediumHighScore());
        }
        backToLeaderboard();
    }

    //Go back to main leaderboard menu.
    private void backToLeaderboard() {
        System.out.println("Whenever you're ready, enter anything to go back...");
        if (scan.next() != null) {
            menuManager.getLeaderboardMenu().display();
        }
    }
}
