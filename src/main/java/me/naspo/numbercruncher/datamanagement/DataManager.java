package me.naspo.numbercruncher.datamanagement;

import me.naspo.numbercruncher.Utils;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

//File management, saving, restoration, data storage, etc...
public class DataManager {

    private File dir;
    private File[] dirListings;
    private File playerFile;
    private YamlConfiguration playerConfig;

    private Logger log;

    private HashMap<String, HashMap<String, Integer>> playerData = new HashMap<>();

    public DataManager() {
        log = Logger.getLogger(DataManager.class.getName());

        mkdirs();
    }

    //Creates the NumberCruncher folder.
    private void mkdirs() {
        dir = new File(System.getenv("ProgramFiles"), "NumberCruncher");
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
        for (Map.Entry<String, HashMap<String, Integer>> entry : playerData.entrySet()) {

            //Create/get the player's file.
            playerFile = new File(dir, entry.getKey() + ".yml");
            if (!(playerFile.exists())) {
                try {
                    playerFile.createNewFile();
                } catch (IOException e) {
                    log.warning("Could not create playerdata file for player " + entry.getKey());
                    e.printStackTrace();
                    return;
                }
            }

            //Load the file as a Yaml configuaration and make the edits.
            playerConfig = YamlConfiguration.loadConfiguration(playerFile);

            playerConfig.set("player-name", entry.getKey());
            playerConfig.set("easy-high-score", entry.getValue().get("easy-high-score"));
            playerConfig.set("medium-high-score", entry.getValue().get("medium-high-score"));
            playerConfig.set("hard-high-score", entry.getValue().get("hard-high-score"));

            //Save the file.
            try {
                playerConfig.save(playerFile);
            } catch (IOException e) {
                log.warning("Could not save playerdata for player uuid " + entry.getKey());
                e.printStackTrace();
            }
        }
    }

    //Restores data from files to the hashmap.
    public void restorePlayerData() {
        if (dir.length() == 0) {
            return;
        }
        for (File file : dirListings) {
            playerConfig = YamlConfiguration.loadConfiguration(file);

            HashMap<String, Integer> stats = new HashMap<>();
            stats.put("easy-high-score", playerConfig.getInt("easy-high-score"));
            stats.put("medium-high-score", playerConfig.getInt("medium-high-score"));
            stats.put("hard-high-score", playerConfig.getInt("hard-high-score"));

            playerData.put(Utils.removeExtension(file.getName()), stats);
        }
    }

    //Getter for playerData hashmap.
    public HashMap<String, HashMap<String, Integer>> getPlayerData() {
        return playerData;
    }
}
