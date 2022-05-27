package me.naspo.numbercruncher.menu.menus;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.menu.MenuManager;

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
        switch (Utils.getInt()) {
            case 1 -> playGame();
            case 2 -> howToPlay();
            case 3 -> leaderboard();
        }
    }

    private void playGame() {
        menuManager.getPlayMenu().display();
    }

    private void howToPlay() {

    }

    private void leaderboard() {

    }
}
