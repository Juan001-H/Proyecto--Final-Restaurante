package co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder;

import co.edu.uniquindio.poo.CommandOrder.Order;

public class Customer extends Person {
    private Order order = null;
    public Customer(String name, String lastName, String iD, String phoneNumber,Order order){
        super(name,lastName,iD,phoneNumber);
        this.order=order;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    
}
