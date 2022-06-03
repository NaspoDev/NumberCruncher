package me.naspo.numbercruncher.menustuff.menus;

import me.naspo.numbercruncher.menustuff.MenuManager;

import java.util.Scanner;

public abstract class Menu {

    protected final Scanner scan = new Scanner(System.in);
    protected MenuManager menuManager;

    Menu(MenuManager menuManager) {
     this.menuManager = menuManager;
    }

    public abstract void display();
}
