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
        System.out.println("NumberCruncher - How to Play");

        System.out.println("Welcome to NumberCruncher!");
        System.out.println("NumberCruncher is a single-player, difficulty based math game.");
        System.out.println("The player is academically challenged by being asked a set of math questions with " +
                "varying difficulties based on the level they selected. Some levels are timed, and some aren't.");

        // --- Steps ---
        System.out.println("\nStep to Start Playing");

        //Step #1
        System.out.println("\nStep #1: Select an option from the main menu. To play, select option 1.");

        //Step #2
        System.out.println("\nStep #2: You'll be prompted to sign in. This is so we can keep track of your awesome");
        System.out.println("high-scores!");
        System.out.println("If you've never played before, select the create account option and follow the prompts.");

        //Step #3
        System.out.println("\nStep #3: You're all set to start playing! At this point you should be in the difficulty");
        System.out.println("select menu. Just select a difficulty and start playing!");
    }

    private void goBack() {
        System.out.println("\nWhenever you're ready, press any key to go back");
        if (scan.next() != null) {
            menuManager.getWelcomeScreen().display();
        }
    }

}
