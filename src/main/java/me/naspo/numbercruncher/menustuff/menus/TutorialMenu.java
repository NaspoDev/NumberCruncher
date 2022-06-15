package me.naspo.numbercruncher.menustuff.menus;

import me.naspo.numbercruncher.menustuff.MenuManager;

public class TutorialMenu extends MenuStructure {


    public TutorialMenu(MenuManager menuManager) {
        super(menuManager);
    }

    @Override
    public void display() {
        displayHelp();
        goBack();
    }

    private void displayHelp() {
        System.out.println("\n==========[ How to Play ]==========\n");

        System.out.println("Welcome to NumberCruncher!");
        System.out.println("NumberCruncher is a single-player, difficulty based math game.");
        System.out.println("The player is academically challenged by being asked a set of math questions with");
        System.out.println("varying difficulties based on the level they selected. Some levels are timed, and some aren't.");

        // --- Steps ---
        System.out.println("\n-----{ Steps to Start Playing }-----");

        //Step #1
        System.out.println("\n[Step #1]: Select an option from the main menu. To play, select option 1.");

        //Step #2
        System.out.println("\n[Step #2]: You'll be prompted to sign in. This is so we can keep track of your awesome");
        System.out.println("high-scores!");
        System.out.println("If you've never played before, select the create account option and follow the prompts.");

        //Step #3
        System.out.println("\n[Step #3]: You're all set to start playing! At this point you should be in the difficulty");
        System.out.println("select menu. Just select a difficulty and start playing!");
    }

    private void goBack() {
        System.out.println("\nWhenever you're ready, enter anything to go back...");
        if (scan.next() != null) {
            System.out.print("\n");
            menuManager.getWelcomeScreen().display();
        }
    }

}
