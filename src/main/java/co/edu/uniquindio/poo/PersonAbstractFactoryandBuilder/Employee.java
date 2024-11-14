package co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder;

public class Employee extends Person {

    private double salary;
    
    public Employee(String name, String lastName, String iD, String PhoneNumber, double salary){
        super(name,lastName,iD,PhoneNumber);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", salario: " + salary;
    }
}
