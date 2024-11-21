package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import co.edu.uniquindio.poo.DeliveryStrategy.Delivery;
import co.edu.uniquindio.poo.DeliveryStrategy.PickUpDelivery;
import co.edu.uniquindio.poo.DeliveryStrategy.StandardDelivery;
import co.edu.uniquindio.poo.ChainOfResponsibilityValidation.ChefHandler;
import co.edu.uniquindio.poo.ChainOfResponsibilityValidation.ComplaintHandler;
import co.edu.uniquindio.poo.ChainOfResponsibilityValidation.ManagerHandler;
import co.edu.uniquindio.poo.ChainOfResponsibilityValidation.WaiterHandler;
import co.edu.uniquindio.poo.CommandOrder.Order;
import co.edu.uniquindio.poo.EmployeeComposite.EmployeeComposite;
import co.edu.uniquindio.poo.EmployeeComposite.EmployeeLeaf;
import co.edu.uniquindio.poo.InvoiceDecorator.BasicInvoice;
import co.edu.uniquindio.poo.InvoiceDecorator.InvoiceComponent;
import co.edu.uniquindio.poo.InvoiceDecorator.TipDecorator;
import co.edu.uniquindio.poo.MenuComposite.MenuHelper;
import co.edu.uniquindio.poo.MenuComposite.MenuItem;
import co.edu.uniquindio.poo.MenuComposite.MenuSection;
import co.edu.uniquindio.poo.PaymentMethodAdapter.CashPayment;
import co.edu.uniquindio.poo.PaymentMethodAdapter.CashPaymentAdapter;
import co.edu.uniquindio.poo.PaymentMethodAdapter.CreditCardPayment;
import co.edu.uniquindio.poo.PaymentMethodAdapter.CreditCardPaymentAdapter;
import co.edu.uniquindio.poo.PaymentMethodAdapter.PaymentMethod;
import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.Customer;
import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.Employee;
import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.PersonFactory;
import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.RestaurantPersonFactory;
import co.edu.uniquindio.poo.ReservationProxy.RealReservation;
import co.edu.uniquindio.poo.ReservationProxy.ResarvationProxy;
import co.edu.uniquindio.poo.ReservationProxy.ReservationService;
import co.edu.uniquindio.poo.Singleton.Restaurant;
import co.edu.uniquindio.poo.StatusObserver.ObserverChef;
import co.edu.uniquindio.poo.StatusObserver.ObserverCustomer;
import co.edu.uniquindio.poo.StatusObserver.ObserverOrder;
import co.edu.uniquindio.poo.TablePrototype.Table;

public class App {
    public static void main(String[] args) {

        // creaciòn de las mesas con el prototype
        Table table = new Table(6, true, "1");
        Table table2 = table.clone();
        table2.setTableNumber("2");
        table.setTableNumber("1");
        Table table3 = table.clone();
        table3.setTableNumber("3");

        // Creaciòn de las personas con AbstractFactory y Builder
        PersonFactory person13 = new RestaurantPersonFactory();

        Employee waiter11 = person13.createEmployee("waiter", "Alan", "Brito", "ID002", "3102653029", 2400.0);

        Employee manager11 = person13.createEmployee("manager", "Daniel", "Brown", "ID003", "321321321", 6000.0);

        Employee manager12 = person13.createEmployee("manager", "Julio", "Profe", "ID004", "3205421520", 5000.0);

        Employee chef11 = person13.createEmployee("chef", "Juan", "johnson", "ID005", "3119856231", 4000.0);

        Employee waiter12 = person13.createEmployee("waiter", "Armando", "Casas", "ID006", "3165428951", 2400.0);

        // Creaciòn del restaurante con todos sus atributos
        Restaurant restaurante = Restaurant.getInstance("Flash Foods");

        restaurante.addTable(table);
        restaurante.addTable(table2);
        restaurante.addTable(table3);

        // Agregaciòn de empleados segùn cargo con el composite
        EmployeeLeaf chef = new EmployeeLeaf(chef11, restaurante.getEmployees());
        EmployeeLeaf waiter = new EmployeeLeaf(waiter11, restaurante.getEmployees());
        EmployeeComposite manager = new EmployeeComposite(manager11, restaurante.getEmployees());
        EmployeeComposite subManager = new EmployeeComposite(manager12, restaurante.getEmployees());
        EmployeeLeaf intern = new EmployeeLeaf(waiter12, restaurante.getEmployees());

        manager.add(chef);
        manager.add(waiter);
        manager.add(subManager);
        subManager.add(intern);

        // Crear Menu Con El Composite
        MenuItem salchipapa = new MenuItem("salchipapa", 10.99, 1, restaurante.getMenu());
        MenuItem pizza = new MenuItem("Pizza", 12.99, 2, restaurante.getMenu());
        MenuItem burger = new MenuItem("Burger", 10.99, 3, restaurante.getMenu());
        MenuItem hotDog = new MenuItem("Hot Dog", 9.99, 9, restaurante.getMenu());
        MenuSection fastFood = new MenuSection(" Fast Food ");
        fastFood.add(pizza);
        fastFood.add(burger);
        fastFood.add(salchipapa);
        fastFood.add(hotDog);

        MenuItem steak = new MenuItem("Steak", 16.99, 4, restaurante.getMenu());
        MenuItem chickenFrisby = new MenuItem("Chicken Frisby", 18.99, 5, restaurante.getMenu());
        MenuSection mainCourse = new MenuSection("Main Course");
        mainCourse.add(steak);
        mainCourse.add(chickenFrisby);

        MenuItem cocaCola = new MenuItem("Coca Cola", 3.99, 6, restaurante.getMenu());
        MenuItem water = new MenuItem("Water", 1.99, 7, restaurante.getMenu());
        MenuItem naturalJuice = new MenuItem("Natural Juice ", 4.99, 8, restaurante.getMenu());
        MenuSection drinks = new MenuSection("Drinks");
        drinks.add(cocaCola);
        drinks.add(water);
        drinks.add(naturalJuice);

        MenuSection menu = new MenuSection("Menu: ");
        menu.add(fastFood);
        menu.add(mainCourse);
        menu.add(drinks);

        Scanner scanner = new Scanner(System.in);
        InvoiceComponent invoice = null;
        int opcion;
        Order order = null;
        Customer customer = null;

        // Creacion De casos Para Probar Las Funcionalidades Del Restaurante
        do {
            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m\n=============================================");
            System.out.println("\033[1m\033[48;5;0m\033[38;5;1m   Welcome To The Restaurant Flash Foods     ");
            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m=============================================");

            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m1. Show Restaurant Details                   \033[0m");

            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m2. Make A Reservation                        \033[0m");

            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m3. Order Food                                \033[0m");

            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m4. Order A Delivery                          \033[0m");

            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m5. Get The Invoice                           \033[0m");

            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m6. Get Order Status                          \033[0m");

            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m7. Make A Complaint                          \033[0m");

            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m8. Pay Invoice                               \033[0m");

            System.out.println("\033[1m\033[48;5;0m\033[38;5;15m9. Exit                                      \033[0m");

            System.out.print("\033[1m\033[48;5;0m\033[38;5;15m Select An Option:                           ");
            opcion = scanner.nextInt();

            switch (opcion) {
                // Prueba Del Metodo Que Mustra Los Detalles Del Restaurante
                case 1:
                    restaurante.showDetails();
                    break;
                // Caso Para Probar La Funcionalidad A La Hora De Crear Reservas
                case 2:

                    System.out.println("Enter customer First name: ");
                    scanner.nextLine();
                    String firstName = scanner.nextLine();
                    System.out.println("Enter customer last name: ");
                    String customerLastName = scanner.nextLine();
                    System.out.println("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.println("Enter customer phone: ");
                    String customerPhone = scanner.nextLine();

                    Customer customer7 = person13.createCustomer(firstName, customerLastName, customerId,
                            customerPhone);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime reservationDate = null;
                    boolean validDate = false;

                    while (!validDate) {
                        System.out.print("Enter reservation date (YYYY-MM-DD HH:MM): ");
                        String dateInput = scanner.nextLine();

                        try {

                            reservationDate = LocalDateTime.parse(dateInput, formatter);
                            if (reservationDate.isAfter(LocalDateTime.now())) {
                                validDate = true;
                            } else {
                                System.out
                                        .println("The Date Of The Reservation Can`t Be Before " + LocalDateTime.now());
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println(
                                    "Error: Invalid date format. Please enter the date in the format YYYY-MM-DD HH:MM");
                        }
                    }

                    boolean people = false;
                    int numberOfPeople = 0;
                    while (!people) {
                        System.out.print("Enter number of people for reservation: ");
                        int numberOfPeople2 = scanner.nextInt();
                        scanner.nextLine();
                        if (numberOfPeople2 <= restaurante.available(reservationDate)) {
                            numberOfPeople = numberOfPeople2;
                            people = true;
                        } else {
                            System.out.println(
                                    "The Number Of People Exceed Our Capacity, The Total Number Of Remaining Seats Is: " + restaurante.available(reservationDate));
                        }
                    }

                    RealReservation reservation = new RealReservation();
                    ReservationService autenticado2 = new ResarvationProxy(reservation, true,
                            restaurante.getReservations());
                            LocalDateTime endTime = null;
                    autenticado2.createReservation(customer7, numberOfPeople, reservationDate,endTime);
                    System.out.println("Reservation added successfully!");
                    break;

                // En Este Caso Se Prueba El Funcionamiento De La Creacion De Ordenes
                case 3:

                    order = new Order();
                    System.out.println("Enter customer First name: ");
                    scanner.nextLine();
                    String firstName2 = scanner.nextLine();

                    customer = person13.createCustomer(firstName2, null, null, null);
                    boolean exit = false;
                    do {
                        menu.displayID();
                        while (true) {
                            System.out.println("Enter ID Number Of The Product That You Want To Add Or 0 To Exit: ");
                            int number = scanner.nextInt();
                            if (number == 0) {
                                System.out.println("Order Taken");
                                System.out.println(customer.getName() + " your order details are: ");
                                order.showDetails();
                                exit = true;
                                break;
                            }
                            MenuItem item = MenuHelper.findFoodItemById(menu, number);
                            if (item != null) {
                                order.addProduct(item);
                            } else {
                                System.out.println("The Id Number Is Incorrect");
                            }
                        }
                    } while (!exit);

                    break;
                // En Este Caso Se Prueba El Funcionamiento De Las Diferentes Estrategias De
                // Delivery
                case 4:
                    Order orderDelivery = new Order();
                    boolean exitDelivery = false;

                    System.out.println("Enter customer First name: ");
                    scanner.nextLine();
                    String firstName3 = scanner.nextLine();

                    customer = person13.createCustomer(firstName3, null, null, null);
                    do {
                        menu.displayID();
                        while (true) {
                            System.out.println("Enter ID Number Of The Product That You Want To Add Or 0 To Exit: ");
                            int number = scanner.nextInt();
                            if (number == 0) {
                                System.out.println("Order Taken");
                                System.out.println(customer.getName() + " your order details are: ");
                                orderDelivery.showDetails();
                                exitDelivery = true;
                                break;
                            }
                            MenuItem item = MenuHelper.findFoodItemById(menu, number);
                            if (item != null) {
                                orderDelivery.addProduct(item);
                            } else {
                                System.out.println("The Id Number Is Incorrect");
                            }
                        }
                    } while (!exitDelivery);

                    BasicInvoice invoiceDelivery = new BasicInvoice(orderDelivery);
                    boolean exit2 = false;
                    do {
                        System.out.println(" Delivery Type");
                        System.out.println("1. Standard Delivery");
                        System.out.println("2. Pick Up Delivery");
                        System.out.print("Select An Option Or 0 To Exit: ");

                        while (true) {
                            System.out.println("Select An Option: ");
                            int number = scanner.nextInt();

                            if (number == 1) {
                                System.out.println("Enter Your Address: ");
                                scanner.nextLine();
                                String address = scanner.nextLine();
                                Delivery standarDelivery = new Delivery(new StandardDelivery());
                                orderDelivery.showDetails();
                                System.out.println(
                                        "The Delivery For The Address: " + address + " Is Ready And has a cost of: "
                                                + standarDelivery.calculateDeliveryCost(invoiceDelivery));

                                exit2 = true;
                                break;
                            } else if (number == 2) {
                                Delivery pickUpDelivery = new Delivery(new PickUpDelivery());
                                orderDelivery.showDetails();
                                System.out.println("your pick up delivery has a cost of: "
                                        + pickUpDelivery.calculateDeliveryCost(invoiceDelivery));

                                exit2 = true;
                                break;
                            } else {
                                System.out.println(" invalid number ");
                            }
                        }
                    } while (!exit2);
                    break;

                // Prueba Del Decorator Para Creacion De Facturas
                case 5:
                    boolean exit3 = false;
                    do {
                        System.out.println("1. Get Basic Invoice");
                        System.out.println("2. Get Invoice plus Tip ");

                        while (true) {
                            System.out.println("Select An Option: ");
                            int number = scanner.nextInt();

                            if (number == 1) {

                                if (order != null) {
                                    invoice = new BasicInvoice(order);
                                    invoice.showDetails();
                                } else {
                                    System.out.println("The order has not been taken ");
                                }
                                exit3 = true;
                                break;
                            } else if (number == 2) {
                                if (order != null) {
                                    System.out.println("Enter The Percentage Of The Tip ");
                                    double amount = scanner.nextDouble();
                                    InvoiceComponent invoice1 = new BasicInvoice(order);
                                    invoice = new TipDecorator(invoice1, amount);
                                    invoice.showDetails();
                                } else {
                                    System.out.println("The order has not been taken ");
                                }
                                exit3 = true;
                                break;
                            }
                        }
                    } while (!exit3);
                    break;

                // Se Prueba La Funcionalidad Del Metodo De Obtener El Estado De La Orden
                case 6:
                    if (customer != null && customer.getName() != null) {
                        if (order != null) {

                            ObserverOrder observerOrder = new ObserverOrder();
                            ObserverChef observerChef = new ObserverChef(chef, customer);
                            ObserverCustomer observerCustomer = new ObserverCustomer(customer);

                            observerOrder.addObserver(observerChef);
                            observerOrder.addObserver(observerCustomer);

                            observerChef.update(" What Is The Status Of The Order For: ");

                            observerCustomer.update(" Your Order Is Ready ");
                        }

                    } else {
                        System.out.println("The Order Has Not Been Taken ");
                    }
                    break;

                // Uso Del Chain Of Responsibility Para Pasar Quejas A Traves De Una Cadena De
                // Manejadores
                case 7:
                    boolean exit4 = false;
                    boolean firstIteration = true;
                    do {
                        System.out.println("1. For A Food Complaint Write: Food Complaint");
                        System.out.println("2. For A Minor Complaint Write: Minor Complaint ");
                        System.out.println("3. For Another Type Of Complaint Write Your Complaint ");

                        if (firstIteration) {
                            scanner.nextLine();
                            firstIteration = false;
                        }

                        System.out.println("Write The Type Of Complaint: ");
                        String complaint = scanner.nextLine();

                        ComplaintHandler chef10 = new ChefHandler();
                        ComplaintHandler waiter10 = new WaiterHandler();
                        ComplaintHandler manager10 = new ManagerHandler();

                        waiter10.setNextHandler(chef10);
                        chef10.setNextHandler(manager10);

                        waiter10.handleComplaint(complaint);

                        System.out.println("Do you want to enter another complaint? (yes/no): ");

                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("no")) {
                            exit4 = true;
                        }

                    } while (!exit4);
                    break;

                // Prueba De Los Metodos De Pago Despues De Generar Una Factur
                case 8:
                    boolean exit5 = false;
                    do {
                        System.out.println("1. Pay In Cash ");
                        System.out.println("2. Pay By Credit Card ");

                        System.out.println("Select An Option: ");
                        int number = scanner.nextInt();

                        CashPayment cash = new CashPayment();
                        CreditCardPayment creditCard = new CreditCardPayment();

                        if (invoice != null) {

                            if (number == 1) {
                                PaymentMethod cashPayment = new CashPaymentAdapter(cash);
                                cashPayment.pay(invoice.getTotalAmount());
                                exit5 = true;
                            } else if (number == 2) {
                                PaymentMethod creditCardPayment = new CreditCardPaymentAdapter(creditCard);
                                creditCardPayment.pay(invoice.getTotalAmount());
                                exit5 = true;
                            }
                        } else {
                            System.out.println("The Invoice Has Not Been Generated");
                            exit5 = true;
                        }

                    } while (!exit5);
                    break;

            }
        } while (opcion != 9);

        scanner.close();

    }
}
