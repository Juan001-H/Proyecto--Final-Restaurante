package co.edu.uniquindio.poo.ReservationProxy;


import java.time.LocalDateTime;
import java.util.List;


import co.edu.uniquindio.poo.PersonAbstractFactoryandBuilder.Customer;

public class ResarvationProxy implements ReservationService{
    private RealReservation realReservation;
    private boolean isAuthorized;

    public ResarvationProxy(RealReservation realReservation, boolean isAuthorized,List<ResarvationProxy>reservations) {
        this.realReservation = realReservation;
        this.isAuthorized = isAuthorized;
        reservations.add(this);
    }

    @Override
    public void createReservation(Customer CustomerName, int peopleNumber, LocalDateTime reservationDate,LocalDateTime endTime) {
        if(isAuthorized ==true){
            realReservation.createReservation(CustomerName, peopleNumber, reservationDate, endTime);
        }else{
            System.out.println("Access denied : you do not have permission to create a reservation");
        }
    }

    @Override
    public void canceledReservation(Customer CustomerName) {
        if(isAuthorized ==true){
            realReservation.canceledReservation(CustomerName);
        }else{
            System.out.println("Access denied : you do not have permission to canceled a reservation");
    }
}

    @Override
    public void showReservationDetails() {
        realReservation.showReservationDetails();
    }
    public void add(ResarvationProxy reservations) {
        throw new UnsupportedOperationException("Cannot add subordinates to a leaf employee");
    }
    public int getPeopleNumber(){
        return realReservation.getPeopleNumber();
    }
    public LocalDateTime getDateTime(){
        return realReservation.getReservationDate();
    }
    public LocalDateTime getendTime(){
        return realReservation.getEndTime();
    }


}
