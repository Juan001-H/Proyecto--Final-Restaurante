package co.edu.uniquindio.poo.StatusObserver;

import co.edu.uniquindio.poo.EmployeeComposite.EmployeeLeaf;
import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.Customer;

public class ObserverChef implements Observer {
    private EmployeeLeaf chef;
    private Customer customer;

    public ObserverChef(EmployeeLeaf chef,Customer customer) {
        this.chef = chef;
        this.customer= customer;
    }

    public EmployeeLeaf getChef() {
        return chef;
    }

    public void setChef(EmployeeLeaf chef) {
        this.chef = chef;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void update(String status) {
        System.out.println("notification For chef: " + chef.getName() + status + customer.getName());
    }
}
