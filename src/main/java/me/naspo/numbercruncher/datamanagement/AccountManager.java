package me.naspo.numbercruncher.datamanagement;

import me.naspo.numbercruncher.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Manages anything to do with account operations. (Account creation, storage, management, etc...).
public class AccountManager {

    private final Scanner scan;
    private boolean loop;

    private List<Account> accountList = new ArrayList<>();
    private Account sessionAccount;

    public AccountManager() {
        scan = new Scanner(System.in);
        loop = true;
    }

    //Sign in prompts and logic.
    public void signIn() {
        System.out.println("Are you new? Press 1 to create an account.");
        System.out.println("Already have an account? Press 2 to login.");

        switch (Utils.getInt(1, 2)) {
            //Create an account.
            case 1 -> createAccount();
            //Login.
            case 2 -> login();
        }
    }

    //Creates an account for a user and sets it as the session account.
    private void createAccount() {
        //Initial prompts.
        System.out.println("Create an Account");
        System.out.println("What would you like your username to be? ");

        do {
            //Gets a username input and checks if an account already exists with that username.
            String username = scan.next();
            if (accountList.stream()
                    .anyMatch(account -> account.getUsername().equalsIgnoreCase(username))) {
                System.out.println("An account with that username already exists!");
                signIn();
                break;
                //System.out.print("Please try again: ");

                //Otherwise, their username is unique, and an account can be created.
            } else {
                Account account = new Account(username);
                accountList.add(account);
                sessionAccount = account;
                System.out.println("Hello, " + username + ". Welcome to NumberCruncher!\n");
                break;
            }
        } while (loop);
    }

    //Logs the user in and sets their account as the session account.
    private void login() {
        System.out.println("Login");
        System.out.println("What is your username? ");

        //Gets a username input and checks if there's an account with that username. If there is, it logs them
        // in by setting their account as the session account.
        String username = scan.next();
        if (accountList.stream()
                .anyMatch(account -> account.getUsername().equalsIgnoreCase(username))) {

            sessionAccount = accountList.stream()
                    .filter(account -> account.getUsername().equalsIgnoreCase(username))
                            .findFirst().get();
            System.out.println("Welcome back " + sessionAccount.getUsername() + "!\n");

            //Otherwise, it returns them back to the main sign in menu.
        } else {
            System.out.println("Unknown username!\n");
            signIn();
        }
    }

    // --- Getters ---

    public List<Account> getAccountList() {
        return accountList;
    }

    public Account getSessionAccount() {
        return sessionAccount;
    }
}
