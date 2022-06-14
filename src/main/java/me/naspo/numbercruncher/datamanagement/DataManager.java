package me.naspo.numbercruncher.datamanagement;

import me.naspo.numbercruncher.Utils;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

//File management, saving, restoration, etc...
public class DataManager {

    private File dir;
    private File[] dirListings;
    private File playerFile;
    private YamlConfiguration playerConfig;

    private Logger log;

    private AccountManager accountManager;
    public DataManager(AccountManager accountManager) {
        this.accountManager = accountManager;

        log = Logger.getLogger(DataManager.class.getName());

        mkdirs();
    }

    //Creates the NumberCruncher folder.
    private void mkdirs() {
        dir = new File(System.getProperty("user.home") + "\\Documents", "NumberCruncher");
        if (!(dir.exists())) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                log.severe("Could not create NumberCruncher folder!");
                log.severe("The game functionally will not work without it!");
                log.severe("Disabling NumberCruncher.");
                log.severe(Arrays.toString(e.getStackTrace()));
                System.exit(0);
                return;
            }
        }
        if (dir.isDirectory()) {
            dirListings = dir.listFiles();
        }
    }

    //Saves hashmap data to files.
    public void savePlayerData() {
        for (Account account : accountManager.getAccountList()) {

            //Create/get the player's file.
            playerFile = new File(dir, account.getUsername() + ".yml");
            if (!(playerFile.exists())) {
                try {
                    playerFile.createNewFile();
                } catch (IOException e) {
                    log.warning("Could not create playerdata file for player " + account.getUsername());
                    e.printStackTrace();
                    return;
                }
            }

            //Load the file as a Yaml configuration and make the edits.
            playerConfig = YamlConfiguration.loadConfiguration(playerFile);

            playerConfig.set("username", account.getUsername());
            playerConfig.set("easy-high-score", account.getEasyHighScore());
            playerConfig.set("medium-high-score", account.getMediumHighScore());
            playerConfig.set("hard-high-score", account.getHardHighScore());

            //Save the file.
            try {
                playerConfig.save(playerFile);
            } catch (IOException e) {
                log.warning("Could not save playerdata for player uuid " + account.getUsername());
                e.printStackTrace();
            }
        }
    }

    //Restores data from files to the hashmap.
    public void restorePlayerData() {
        if (dirListings.length == 0) {
            return;
        }
        for (File file : dirListings) {
            playerConfig = YamlConfiguration.loadConfiguration(file);

            Account account = new Account(Utils.removeExtension(file.getName()));

            account.setEasyHighScore(playerConfig.getInt("easy-high-score"));
            account.setMediumHighScore(playerConfig.getInt("medium-high-score"));
            account.setHardHighScore(playerConfig.getInt("hard-high-score"));

           accountManager.getAccountList().add(account);
        }
    }
}
