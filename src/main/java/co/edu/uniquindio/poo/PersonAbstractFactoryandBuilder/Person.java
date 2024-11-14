package co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder;

public abstract class Person {
    private String Name;
    private String lastName;
    private String ID;
    private String PhoneNumber;

    public Person(String name, String lastName, String iD, String phoneNumber) {
        Name = name;
        this.lastName = lastName;
        ID = iD;
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    @Override
    public String toString() {
        return "Person [Name=" + Name + ", lastName=" + lastName + ", ID=" + ID + ", PhoneNumber=" + PhoneNumber + "]";
    }

}
