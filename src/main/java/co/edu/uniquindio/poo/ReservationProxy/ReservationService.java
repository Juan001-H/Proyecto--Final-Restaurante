package co.edu.uniquindio.poo.ReservationProxy;



import java.time.LocalDateTime;

import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.Customer;

public interface ReservationService {
    void createReservation(Customer CustomerName, int peopleNumber,LocalDateTime reservationDate,LocalDateTime endTime);
    void canceledReservation(Customer CustomerName);
    void showReservationDetails();
}
