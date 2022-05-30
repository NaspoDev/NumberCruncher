package me.naspo.numbercruncher.datamanagement;

import java.util.HashMap;

//Manages anything to do with account operations. (Account creation, etc...).
public class AccountManager {

    //left off here: change the structure from a hashmap with the raw data to object classes for each account?

    private DataManager dataManager;
    public AccountManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    //Creates an account for a user.
    public void createAccount(String username) {
        if (!(hasAccount(username))) {
            //Create blank stats.
            HashMap<String, Integer> stats = new HashMap<>();
            stats.put("easy-high-score", 0);
            stats.put("medium-high-score", 0);
            stats.put("hard-high-score", 0);

            //Add them to the hashmap.
            dataManager.getPlayerData().put(username, stats);
        }
    }

    //Checks if they specified user already has an account.
    public boolean hasAccount(String username) {
        if (!(dataManager.getPlayerData().isEmpty())) {
            return dataManager.getPlayerData().containsKey(username);
        }
        return false;
    }
}
