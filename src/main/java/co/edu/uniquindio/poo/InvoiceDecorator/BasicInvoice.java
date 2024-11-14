package co.edu.uniquindio.poo.InvoiceDecorator;


import co.edu.uniquindio.poo.CommandOrder.Order;
import co.edu.uniquindio.poo.MenuComposite.MenuItem;
import co.edu.uniquindio.poo.PaymentMethodAdapter.PaymentMethod;

public class BasicInvoice implements InvoiceComponent{

    private Order order;

    public BasicInvoice(Order order){
        this.order= order;
    }

    @Override
    public double getTotalAmount() {
        return order.getItems().stream().mapToDouble(MenuItem::getPrice).sum();
    }

    @Override
    public void showDetails() {
        System.out.println("Invoice Details:");
        for (MenuItem item : order.getItems()) {
            System.out.println(" - " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Subtotal: $" + getTotalAmount());
    }

    @Override
    public void payInvoice(PaymentMethod payment) {
        payment.pay(getTotalAmount());
    }
    
}
