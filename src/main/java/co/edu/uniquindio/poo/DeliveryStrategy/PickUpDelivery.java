package co.edu.uniquindio.poo.DeliveryStrategy;

public class PickUpDelivery implements DeliveryStrategy{

    @Override
    public double calculateCost(double price) {
        return price + 2.0;
    }
    
}
