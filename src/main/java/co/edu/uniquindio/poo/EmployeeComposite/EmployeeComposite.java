package co.edu.uniquindio.poo.EmployeeComposite;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.Employee;

public class EmployeeComposite implements EmployeeComponent{
    private List<EmployeeComponent>SubOrdinates =new ArrayList<>();
    private Employee employee;

    public EmployeeComposite(Employee employee,List<EmployeeComponent>employees) {
        this.employee = employee;
        employees.add(this);

    }
    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public String getlastName() {
        return employee.getLastName();
    }

    @Override
    public String getPhone() {
        return employee.getPhoneNumber();
    }

    @Override
    public String getiD() {
        return employee.getID();
    }

    @Override
    public Double getSalary() {
        return employee.getSalary();
    }


    @Override
    public void add(EmployeeComponent employee) {
        SubOrdinates.add(employee);
    }

    @Override
    public void remove(EmployeeComponent employee) {
        SubOrdinates.remove(employee);
    }

    @Override
    public List<EmployeeComponent> getSubOrdinates() {
        return SubOrdinates;
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + employee.getName() + " " + employee.getLastName() + ", Phone: " + employee.getPhoneNumber() + ", ID : " + employee.getID() + " , Salary:$" + employee.getSalary());
        System.out.println("Subordinates:");
        for (EmployeeComponent subordinate : SubOrdinates) {
            subordinate.showDetails();
        }
    }
}
