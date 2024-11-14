package co.edu.uniquindio.poo.MenuComposite;

import java.util.ArrayList;
import java.util.List;

public class MenuSection implements MenuComponent {
    private List<MenuComponent> items = new ArrayList<>();
    private String name;
    public MenuSection(String name) {
        this.name = name;
    }
    @Override
    public void add(MenuComponent menuComponent) {
        items.add(menuComponent);
    }
    @Override
    public void remove(MenuComponent menuComponent) {
        items.remove(menuComponent);
    }
    @Override
    public void display() {
        System.out.println("Section: " + name );
        for (MenuComponent item : items) {
            item.display();
        }
    }
    public List<MenuComponent> getItems() {
        return items;
    }
    public void displayID(){
        System.out.println("Section: " + name );
        for (MenuComponent item : items) {
            item.displayID();
        }
    }
    @Override
    public int getIDItem() {
        int id = 0;
        for (MenuComponent menuComponent : items) {
            id = menuComponent.getIDItem();
        }
        return id;
    }
    @Override
    public boolean isMenuItem() {
        boolean isMenuItem = false;

        for (MenuComponent menuComponent : items) {
            isMenuItem= menuComponent.isMenuItem();
        }
        return isMenuItem;
    }
}


