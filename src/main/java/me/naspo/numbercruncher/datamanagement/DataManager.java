package me.naspo.numbercruncher.datamanagement;

import me.naspo.numbercruncher.Utils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataManager {

    private File dir;
    private File[] dirListings;
    private File playerFile;
    private YamlConfiguration playerConfig;

    private Logger log;

    public static HashMap<String, HashMap<String, Integer>> playerData = new HashMap<>();

    public DataManager() {
        log = Logger.getLogger(DataManager.class.getName());

        mkdirs();
        //saveDefaultConfig();

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

    public void saveData() {
        for (Map.Entry<String, HashMap<String, Integer>> entry : playerData.entrySet()) {

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

            playerConfig = YamlConfiguration.loadConfiguration(playerFile);

            playerConfig.set("player-name", entry.getKey());
            playerConfig.set("easy-high-score", entry.getValue().get("easy-high-score"));
            playerConfig.set("medium-high-score", entry.getValue().get("medium-high-score"));
            playerConfig.set("hard-high-score", entry.getValue().get("hard-high-score"));

            try {
                playerConfig.save(playerFile);
            } catch (IOException e) {
                log.warning("Could not save playerdata for player uuid " + entry.getKey());
                e.printStackTrace();
            }
        }
    }

    public void restoreData() {
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

}
