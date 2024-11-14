package co.edu.uniquindio.poo.MenuComposite;

public class MenuHelper {
    
    public static MenuItem findFoodItemById(MenuComponent component, int id) {
        // Verificar si el componente es una instancia de MenuItem
        if (component instanceof MenuItem) {
            MenuItem item = (MenuItem) component;
            if (item.getIDItem() == id) {
                return item;
            }
        }
        // Si es una instancia de MenuSection, recorrer sus subcomponentes
        else if (component instanceof MenuSection) {
            MenuSection section = (MenuSection) component;
            for (MenuComponent subComponent : section.getItems()) {
                MenuItem item = findFoodItemById(subComponent, id); // llamada recursiva
                if (item != null) {
                    return item;
                }
            }
        }
        // Retorna null si no se encuentra el item
        return null;
    }
}