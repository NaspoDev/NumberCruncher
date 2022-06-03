package me.naspo.numbercruncher.menustuff;

import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.menustuff.menus.TutorialMenu;
import me.naspo.numbercruncher.menustuff.menus.LeaderboardMenu;
import me.naspo.numbercruncher.menustuff.menus.PlayMenu;
import me.naspo.numbercruncher.menustuff.menus.WelcomeScreen;

public class MenuManager {

    private WelcomeScreen welcomeScreen;
    private PlayMenu playMenu;
    private TutorialMenu tutorialMenu;
    private LeaderboardMenu leaderboardMenu;

    private AccountManager accountManager;
    public MenuManager(AccountManager accountManager) {
        this.accountManager = accountManager;

        welcomeScreen = new WelcomeScreen(this);
        playMenu = new PlayMenu(this, accountManager);
        tutorialMenu = new TutorialMenu(this);
        leaderboardMenu = new LeaderboardMenu(this, accountManager);
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
