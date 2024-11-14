package co.edu.uniquindio.poo.CommandOrder;

import co.edu.uniquindio.poo.MenuComposite.MenuItem;

public class RemoveProductCommand implements OrderCommand {
    private Order order;
    private MenuItem item;

    public RemoveProductCommand(Order order, MenuItem item) {
        this.order = order;
        this.item = item;
    }

    @Override
    public void execute() {
        order.removeProduct(item);
        System.out.println("Product" + item.getName()+ " removed to the order");
    }

    @Override
    public void undo() {
        order.addProduct(item);
        System.out.println("Product" + item.getName()+ " re-added to the order");
    }

}
