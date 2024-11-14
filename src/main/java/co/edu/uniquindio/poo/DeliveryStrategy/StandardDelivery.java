package co.edu.uniquindio.poo.DeliveryStrategy;

public class StandardDelivery implements DeliveryStrategy {

    @Override
    public double calculateCost(double price) {
        return price + 10.0;
    }

}
