package me.naspo.numbercruncher.datamanagement;

//Account object class. Each account on the computer is represented/stored here in runtime.
public class Account {

    private String username;
    private int easyHighScore;
    private int mediumHighScore;
    private int hardHighScore;

    Account(String username) {
        this.username = username;
        easyHighScore = 0;
        mediumHighScore = 0;
        hardHighScore = 0;
    }

    // --- Getters ---

    public String getUsername() {
        return username;
    }

    public int getEasyHighScore() {
        return easyHighScore;
    }

    public int getMediumHighScore() {
        return mediumHighScore;
    }

    public int getHardHighScore() {
        return hardHighScore;
    }

    // --- Setters ---

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEasyHighScore(int easyHighScore) {
        this.easyHighScore = easyHighScore;
    }

    public void setMediumHighScore(int mediumHighScore) {
        this.mediumHighScore = mediumHighScore;
    }

    public void setHardHighScore(int hardHighScore) {
        this.hardHighScore = hardHighScore;
    }
}
