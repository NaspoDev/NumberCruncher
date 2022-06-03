package me.naspo.numbercruncher.menustuff.menus;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.menustuff.MenuManager;

public class WelcomeScreen extends Menu {

    public WelcomeScreen(MenuManager menuManager) {
        super(menuManager);
    }

    //Display the welcome screen and its options.
    public void display() {
        System.out.println("Welcome to NumberCruncher!");
        System.out.format("%-10s %10s %n", "1 - Play", "2 - How to Play");
        System.out.format("%-20s %n", "3 - Leaderboard");

        input();
    }

    private void input() {
        switch (Utils.getInt(1, 3)) {
            //Play
            case 1 -> playGame();
            //How to Play
            case 2 -> howToPlay();
            //Leaderboard
            case 3 -> leaderboard();
        }
    }

    private void playGame() {
        menuManager.getPlayMenu().display();
    }

    private void howToPlay() {
        menuManager.getTutorialMenu().display();
    }

    private void leaderboard() {
        menuManager.getLeaderboardMenu().display();
    }
}
