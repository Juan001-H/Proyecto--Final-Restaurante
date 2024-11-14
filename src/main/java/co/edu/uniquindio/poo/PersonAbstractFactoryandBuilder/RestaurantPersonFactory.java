package co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder;

public class RestaurantPersonFactory implements PersonFactory {
    private PersonBuilder builder = new PersonBuilder();

    @Override
    public Customer createCustomer(String name, String lastName, String iD, String PhoneNumber) {
        return builder.setName(name).setLastName(lastName).setID(iD).setPhoneNumber(PhoneNumber).buildCustomer();
    }

    @Override
    public Employee createEmployee(String employeeType, String name, String lastName, String iD, String PhoneNumber,
            double salary) {
        builder.setName(name).setLastName(lastName).setID(iD).setPhoneNumber(PhoneNumber).setSalary(salary)
                .buildCustomer();
        switch (employeeType.toLowerCase()) {
            case "cashier":
                return builder.buildCashier();
            case "chef":
                return builder.buildChef();
            case "manager":
                return builder.buildManager();
            case "waiter":
                return builder.buildManager();

            default:
                throw new IllegalArgumentException("unknown employee Type" + employeeType);

        }
    }

}
