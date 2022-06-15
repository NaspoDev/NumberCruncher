package me.naspo.numbercruncher.menustuff.menus;

import me.naspo.numbercruncher.Utils;
import me.naspo.numbercruncher.datamanagement.Account;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.menustuff.MenuManager;

import java.util.*;

public class LeaderboardMenu extends MenuStructure {

    private AccountManager accountManager;
    public LeaderboardMenu(MenuManager menuManager, AccountManager accountManager) {
        super(menuManager);
        this.accountManager = accountManager;
    }

    //Displays main leaderboard screen and prompts the user to choose a leaderboard.
    @Override
    public void display() {
        System.out.println("\n==========[ The Leaderboard ]==========");
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
            case 4 -> {
                System.out.print("\n");
                menuManager.getWelcomeScreen().display();
            }
        }
    }

    //Sorts and displays leaderboard stats in order of greatest to least.
    private void easyLeaderboard() {
        System.out.println("\n-----{ Easy Leaderboard }-----");
        System.out.format("%-10s %10s %n", "Username", "High-score");

        //Add all the usernames and their easy high-scores in a hashmap.
        HashMap<String, Integer> easyStatsUnsorted = new HashMap<>();
        for (Account account : accountManager.getAccountList()) {
            easyStatsUnsorted.put(account.getUsername(), account.getEasyHighScore());
        }

        //Holds easyStatsUnsorted entries to be sorted with Collections.sort().
        List<Map.Entry<String, Integer>> easyStatsSorted = new ArrayList<>(easyStatsUnsorted.entrySet());
        easyStatsSorted = sortEntryList(easyStatsSorted);

        //Final output.
        easyStatsSorted.forEach(e -> System.out.format("%-10s %10s %n", e.getKey(), e.getValue()));

        backToLeaderboard();
    }

    private void mediumLeaderboard() {
        System.out.println("\n-----{ Medium Leaderboard }-----");
        System.out.format("%-10s %10s %n", "Username", "High-score");

        //Add all the usernames and their medium high-scores in a hashmap.
        HashMap<String, Integer> mediumStatsUnsorted = new HashMap<>();
        for (Account account : accountManager.getAccountList()) {
            mediumStatsUnsorted.put(account.getUsername(), account.getMediumHighScore());
        }

        //Holds mediumStatsUnsorted entries to be sorted with Collections.sort().
        List<Map.Entry<String, Integer>> mediumStatsSorted = new ArrayList<>(mediumStatsUnsorted.entrySet());
        mediumStatsSorted = sortEntryList(mediumStatsSorted);

        //Final output.
        mediumStatsSorted.forEach(e -> System.out.format("%-10s %10s %n", e.getKey(), e.getValue()));

        backToLeaderboard();
    }

    private void hardLeaderboard() {
        System.out.println("\n-----{ Hard Leaderboard }-----");
        System.out.format("%-10s %10s %n", "Username", "High-score");

        //Add all the usernames and their hard high-scores in a hashmap.
        HashMap<String, Integer> hardStatsUnsorted = new HashMap<>();
        for (Account account : accountManager.getAccountList()) {
            hardStatsUnsorted.put(account.getUsername(), account.getHardHighScore());
        }

        //Holds hardStatsUnsorted entries to be sorted with Collections.sort().
        List<Map.Entry<String, Integer>> hardStatsSorted = new ArrayList<>(hardStatsUnsorted.entrySet());
        hardStatsSorted = sortEntryList(hardStatsSorted);

        //Final output.
        hardStatsSorted.forEach(e -> System.out.format("%-10s %10s %n", e.getKey(), e.getValue()));

        backToLeaderboard();
    }

    //Creates and uses a custom Comparator with Collections.sort() to sort and return a given list
    // of type Map.Entry<String, Integer>.
    private List<Map.Entry<String, Integer>> sortEntryList(List<Map.Entry<String, Integer>> list) {
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }

    //Go back to main leaderboard menu.
    private void backToLeaderboard() {
        System.out.println("\nWhenever you're ready, enter anything to go back...");
        if (scan.next() != null) {
            menuManager.getLeaderboardMenu().display();
        }
    }
}
