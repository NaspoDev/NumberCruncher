package me.naspo.numbercruncher.levelstuff;

import me.naspo.numbercruncher.Main;
import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.levelstuff.levels.EasyLevel;
import me.naspo.numbercruncher.levelstuff.levels.HardLevel;
import me.naspo.numbercruncher.levelstuff.levels.MediumLevel;

public class LevelManager {

    private EasyLevel easyLevel;
    private MediumLevel mediumLevel;
    private HardLevel hardLevel;

    private AccountManager accountManager;
    private Main game;

    public LevelManager(AccountManager accountManager, Main game) {
        this.accountManager = accountManager;
        this.game = game;

        easyLevel = new EasyLevel(this, accountManager, game);
        mediumLevel = new MediumLevel(this, accountManager, game);
        hardLevel = new HardLevel(this, accountManager, game);
    }

    // --- Level starters ---

    public void startEasyLevel() {
        easyLevel.start();
    }

    public void startMediumLevel() {
        mediumLevel.start();
    }

    public void startHardLevel() {
        hardLevel.start();
    }
}
