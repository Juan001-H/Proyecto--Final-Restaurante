package co.edu.uniquindio.poo.EmployeeComposite;

import java.util.List;

import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.Employee;

public class EmployeeLeaf implements EmployeeComponent {
    private Employee employee;

    public EmployeeLeaf(Employee employee,List<EmployeeComponent>employees) {
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
        throw new UnsupportedOperationException("Cannot add subordinates to a leaf employee");
    }


    @Override
    public void remove(EmployeeComponent employee) {
        throw new UnsupportedOperationException("Cannot remove subordinates from a leaf employee");
    }


    @Override
    public List<EmployeeComponent> getSubOrdinates() {
        throw new UnsupportedOperationException("Leaf employee has no subordinates");
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + employee.getName() + " " + employee.getLastName() + ", Phone: " + employee.getPhoneNumber() + ", ID : " + employee.getID() + " , Salary:$" + employee.getSalary());
    }

}

