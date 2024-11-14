package co.edu.uniquindio.poo.CommandOrder;

import co.edu.uniquindio.poo.MenuComposite.MenuItem;

public class AddProductCommand implements OrderCommand {
    private Order order;
    private MenuItem item;

    public AddProductCommand(Order order, MenuItem item) {
        this.order = order;
        this.item = item;
    }

    @Override
    public void execute() {
        order.addProduct(item);
        System.out.println("Product" + item.getName()+ " added to the order");
    }

    @Override
    public void undo() {
        order.removeProduct(item);
        System.out.println("Product" + item.getName()+ " added to the order");
    }

}
