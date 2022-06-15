package me.naspo.numbercruncher.menustuff.menus;

import me.naspo.numbercruncher.menustuff.MenuManager;

import java.util.Scanner;

//Abstract Menu class. Contains level class structure and other important methods and objects.
public abstract class MenuStructure {

    protected final Scanner scan = new Scanner(System.in);
    protected MenuManager menuManager;

    MenuStructure(MenuManager menuManager) {
     this.menuManager = menuManager;
    }

    public abstract void display();
}
