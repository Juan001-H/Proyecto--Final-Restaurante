package co.edu.uniquindio.poo.PaymentMethodAdapter;

public class CreditCardPaymentAdapter implements PaymentMethod {
    private CreditCardPayment creditCard;

    public CreditCardPaymentAdapter(CreditCardPayment creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public void pay(double amount) {
        creditCard.payByCreditCard(amount);
    }
}
