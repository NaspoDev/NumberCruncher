package me.naspo.numbercruncher;

import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.datamanagement.DataManager;
import me.naspo.numbercruncher.menustuff.MenuManager;

public class Main {

    private AccountManager accountManager;
    private DataManager dataManager;
    private MenuManager menuManager;
    //new LevelManager? or something w/ object classes

    //Startup method.
    public static void main(String[] args) {
        Main game = new Main();

        game.instantiateClasses();
        game.dataManager.restorePlayerData();
        game.start();

        //Runtime event for program end.
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                game.onDisable();
            }
        }));
    }

    //Called when the program finishes.
    public void onDisable() {
        dataManager.savePlayerData();
    }

    private void instantiateClasses() {
        accountManager = new AccountManager();
        dataManager = new DataManager(accountManager);
        menuManager = new MenuManager(accountManager);
    }

    //Start the game by displaying the welcome screen.
    private void start() {
        menuManager.getWelcomeScreen().display();
    }
}
