package co.edu.uniquindio.poo.ReservationProxy;


import java.time.LocalDateTime;

import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.Customer;

public class RealReservation implements ReservationService {
    private Customer CustomerName;
    private int peopleNumber;
    private LocalDateTime reservationDate;

    @Override
    public void createReservation(Customer CustomerName, int peopleNumber, LocalDateTime reservationDate) {
        this.CustomerName = CustomerName;
        this.peopleNumber = peopleNumber;
        this.reservationDate = reservationDate;

        System.out.println("Reservation created in name of : " + CustomerName.getName() + " For a party of : " + peopleNumber + " , On : " + reservationDate);

    }

    @Override
    public void canceledReservation(Customer CustomerName) {
        if (this.CustomerName != null && this.CustomerName.equals(CustomerName)) {
            System.out.println("Reservation for " + CustomerName.getName() + " has been canceled.");
            this.CustomerName = null;
            this.peopleNumber = 0;
            this.reservationDate = null;
        } else {
            System.out.println("No reservation found for " + CustomerName.getName());
        }
    }

    @Override
    public void showReservationDetails() {
        if (CustomerName != null) {
            System.out.println("Reservation Details:");
            System.out.println("Customer Name: " + CustomerName.getName());
            System.out.println("Table Number: " + peopleNumber);
            System.out.println("Date: " + reservationDate);
        } else {
            System.out.println("No reservation available.");
        }
    }
}
