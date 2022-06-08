package me.naspo.numbercruncher.levelstuff;

import me.naspo.numbercruncher.datamanagement.AccountManager;
import me.naspo.numbercruncher.levelstuff.levels.EasyLevel;
import me.naspo.numbercruncher.levelstuff.levels.HardLevel;
import me.naspo.numbercruncher.levelstuff.levels.MediumLevel;

public class LevelManager {

    private EasyLevel easyLevel;
    private MediumLevel mediumLevel;
    private HardLevel hardLevel;

    private AccountManager accountManager;

    public LevelManager(AccountManager accountManager) {
        this.accountManager = accountManager;

        easyLevel = new EasyLevel(this, accountManager);
        mediumLevel = new MediumLevel(this, accountManager);
        hardLevel = new HardLevel(this, accountManager);
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
