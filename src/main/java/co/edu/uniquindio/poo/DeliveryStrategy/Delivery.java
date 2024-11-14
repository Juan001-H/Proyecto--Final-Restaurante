package co.edu.uniquindio.poo.DeliveryStrategy;

import co.edu.uniquindio.poo.InvoiceDecorator.InvoiceComponent;

public class Delivery {
    private DeliveryStrategy deliveryStrategy;

    public Delivery(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public double calculateDeliveryCost(InvoiceComponent invoice){
        return deliveryStrategy.calculateCost( invoice.getTotalAmount());
    }
}
