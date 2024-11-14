package co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder;

import co.edu.uniquindio.poo.CommandOrder.Order;

public  class PersonBuilder {
    protected String Name;
    protected String lastName;
    protected String ID;
    protected double salary;
    protected String PhoneNumber;
    protected Order order;

    public PersonBuilder setName(String name) {
        this.Name = name;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setID(String iD) {
        this.ID = iD;
        return this;
    }

    public PersonBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public PersonBuilder setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
        return this;
    }
    public Customer buildCustomer(){
        return new Customer(Name, lastName, ID, PhoneNumber,order);
    }
    public Cashier buildCashier(){
        return new Cashier(Name, lastName, ID, salary,PhoneNumber);
    }
    public Waiter buildWaiter(){
        return new Waiter(Name, lastName, ID, salary,PhoneNumber);
    }
    public Chef buildChef(){
        return new Chef(Name, lastName, ID, salary,PhoneNumber);
    }
    public Manager buildManager(){
        return new Manager(Name, lastName, ID, salary,PhoneNumber);
    }
}
