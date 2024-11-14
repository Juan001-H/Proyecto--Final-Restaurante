package co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder;

public interface PersonFactory  {
    Customer createCustomer(String name, String lastName, String iD, String PhoneNumber);
    Employee createEmployee(String employeeType,String name, String lastName, String iD, String PhoneNumber, double salary);

}
