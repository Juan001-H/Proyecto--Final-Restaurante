package co.edu.uniquindio.poo.Singleton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.poo.EmployeeComposite.EmployeeComponent;
import co.edu.uniquindio.poo.MenuComposite.MenuItem;
import co.edu.uniquindio.poo.ReservationProxy.ResarvationProxy;
import co.edu.uniquindio.poo.TablePrototype.Table;

public class Restaurant {
    private static Restaurant instance;
    private String name;
    private List<Table> tables;
    private List<EmployeeComponent> employees;
    private List<MenuItem> menu;
    private List<ResarvationProxy> reservations;

    private Restaurant(String name) {
        this.name = name;
        this.tables = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.menu = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public List<EmployeeComponent> getEmployees() {
        return employees;
    }

    public List<Table> getTables() {
        return tables;
    }

    public List<ResarvationProxy> getReservations() {
        return reservations;
    }

    public static synchronized Restaurant getInstance(String name) {
        if (instance == null) {
            instance = new Restaurant(name);
        }
        return instance;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void addEmployee(EmployeeComponent employee) {
        employees.add(employee);
    }

    public void removeEmployee(EmployeeComponent employee) {
        employees.remove(employee);
    }

    public void addProduct(MenuItem item) {
        menu.add(item);
    }

    public void addReservation(ResarvationProxy reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(ResarvationProxy reservation) {
        reservations.remove(reservation);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void showDetails() {
        System.out.println(
                "Restaurant Name: " + name + "', tables: " + tables.size() + ", employees: " + employees.size());

        System.out.println("Employees: ");
        for (EmployeeComponent employee : employees) {
            System.out.println("Employee: " + employee.getName() + " " + employee.getlastName() + ", Phone: "
                    + employee.getPhone() + ", ID : " + employee.getiD());
        }
        System.out.println("Menu:");
        for (MenuItem menuitem : menu) {
            menuitem.display();
        }
        System.out.println("Tables: ");
        for (Table table : tables) {
            table.showDetails();
        }
    }

    public int totalseats() {
        int totalSeats = 0;
        for (Table table : tables) {
            totalSeats += table.getSeat();
        }
        return totalSeats;
    }

    public int availableSeats(LocalDateTime newReservationTime) {
        int seats = totalseats();
        ResarvationProxy closestReservation = null;

        for (ResarvationProxy reservation : reservations) {
            if (reservation.getendTime().isAfter(newReservationTime)) {
                closestReservation = reservation;
            }else{
                if(reservation.getDateTime().minusHours(2).isBefore(newReservationTime)){
                    closestReservation = reservation;
                }
            }
        }

        if (closestReservation != null) {
            seats -= closestReservation.getPeopleNumber();
        }
        return seats;
    }

    public int available(LocalDateTime datee) {
        int seats = totalseats();

        for (ResarvationProxy resarvationProxy : reservations) {
            if (datee.isAfter(resarvationProxy.getendTime())
                    || datee.isBefore(resarvationProxy.getDateTime().minusHours(2))) {
                seats = totalseats();
            } else {
                seats = availableSeats(datee);
            }
        }
        return seats;
    }

}