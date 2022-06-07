package me.naspo.numbercruncher.menustuff.menus;

import me.naspo.numbercruncher.menustuff.MenuManager;

import java.util.Scanner;

public abstract class MenuCore {

    protected final Scanner scan = new Scanner(System.in);
    protected MenuManager menuManager;

    MenuCore(MenuManager menuManager) {
     this.menuManager = menuManager;
    }

    public abstract void display();
}
