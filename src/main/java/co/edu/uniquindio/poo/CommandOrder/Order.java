package co.edu.uniquindio.poo.CommandOrder;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.poo.MenuComposite.MenuItem;

public class Order {
    private List<MenuItem>items = new ArrayList<>();
    private List<OrderCommand>commandHistory = new ArrayList<>();

    public Order() {
    }

    public void addProduct(MenuItem item){
        items.add(item);
    }
    public void removeProduct(MenuItem item){
        items.remove(item);
    }

    public void executeCommand(OrderCommand orderCommand){
        orderCommand.execute();
        commandHistory.add(orderCommand);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void undoLastCommand(){
        if (!commandHistory.isEmpty()) {
            OrderCommand lastCommand = commandHistory.remove(commandHistory.size() - 1);
            lastCommand.undo();
        } else {
            System.out.println("No commands to undo.");
        }
    }
    public void showDetails(){
        System.out.println("order details: ");
        for (MenuItem item : items) {
            System.out.println(item.getName() + "Price: $" + item.getPrice());
        } 
    }
}

