package co.edu.uniquindio.poo.MenuComposite;

public interface MenuComponent {
    void add(MenuComponent menuComponent);
    void remove(MenuComponent menuComponent);
    boolean isMenuItem();
    int getIDItem();
    void display();
    void displayID();

}
