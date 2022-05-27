package me.naspo.numbercruncher.menu;

import me.naspo.numbercruncher.menu.menus.TutorialMenu;
import me.naspo.numbercruncher.menu.menus.LeaderboardMenu;
import me.naspo.numbercruncher.menu.menus.PlayMenu;
import me.naspo.numbercruncher.menu.menus.WelcomeScreen;

public class MenuManager {

    private WelcomeScreen welcomeScreen;
    private PlayMenu playMenu;
    private TutorialMenu tutorialMenu;
    private LeaderboardMenu leaderboardMenu;

    public MenuManager() {
        welcomeScreen = new WelcomeScreen(this);
        playMenu = new PlayMenu(this);
        tutorialMenu = new TutorialMenu(this);
        leaderboardMenu = new LeaderboardMenu(this);
    }


    // --- Getters ---

    public WelcomeScreen getWelcomeScreen() {
        return welcomeScreen;
    }

    public PlayMenu getPlayMenu() {
        return playMenu;
    }

    public TutorialMenu getTutorialMenu() {
        return tutorialMenu;
    }

    public LeaderboardMenu getLeaderboardMenu() {
        return leaderboardMenu;
    }
}
