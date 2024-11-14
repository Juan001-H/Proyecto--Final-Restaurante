package co.edu.uniquindio.poo.EmployeeComposite;

import java.util.List;

public interface EmployeeComponent {
    String getName();
    String getlastName();
    String getPhone();
    String getiD();
    Double getSalary();
    void add(EmployeeComponent employee);
    void remove(EmployeeComponent employee);
    List<EmployeeComponent>getSubOrdinates();
    void showDetails();
}
