package me.naspo.numbercruncher;

import me.naspo.numbercruncher.datamanagement.DataManager;
import me.naspo.numbercruncher.menu.MenuManager;

public class Main {

    private Utils utils;
    private DataManager dataManager;
    private MenuManager menuManager;
    //new LevelManager? or something w/ object classes

    public static void main(String[] args) {
        Main game = new Main();

        game.instantiateClasses();
        game.start();

        //Runtime event for program end.
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                onDisable();
            }
        }));
    }

    //Called when the program finishes.
    public static void onDisable() {

    }

    private void instantiateClasses() {
        utils = new Utils();
        dataManager = new DataManager();
        menuManager = new MenuManager();
    }

    //Start the game by displaying the welcome screen.
    private void start() {
        menuManager.getWelcomeScreen().display();
    }
}
