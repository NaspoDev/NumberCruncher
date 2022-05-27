package me.naspo.numbercruncher.menu.menus;

import me.naspo.numbercruncher.menu.MenuManager;

import java.util.Scanner;

public abstract class Menu {

    protected final Scanner scan = new Scanner(System.in);
    protected MenuManager menuManager;

    Menu(MenuManager menuManager) {
     this.menuManager = menuManager;
    }

    public abstract void display();
}
