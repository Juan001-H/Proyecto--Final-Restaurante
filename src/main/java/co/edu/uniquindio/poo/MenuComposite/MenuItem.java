package co.edu.uniquindio.poo.MenuComposite;

import java.util.List;

public class MenuItem implements MenuComponent {
    private int IDItem;
    private String name;
    private double price;

    public MenuItem(String name, double price,int IDItem,List<MenuItem>menu) {
        this.name = name;
        this.price = price;
        this.IDItem=IDItem;
        menu.add(this);

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void display() {
        System.out.println("Item: " + name + ", price: $" + price);
    }
    public void displayID(){
        System.out.println("id: " + IDItem + ", Item: " + name );
    }
    @Override
    public int getIDItem() {
        return IDItem;
    }

    @Override
    public boolean isMenuItem() {
        return true;
    }

}
