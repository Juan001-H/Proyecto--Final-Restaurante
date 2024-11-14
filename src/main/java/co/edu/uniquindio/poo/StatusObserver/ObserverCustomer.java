package co.edu.uniquindio.poo.StatusObserver;

import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.Customer;

public class ObserverCustomer implements Observer {
    private Customer customer;

    public ObserverCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void update(String status) {
        System.out.println("notification For Customer : " + customer.getName() + " the status of your order is: " + status);
    }

}
