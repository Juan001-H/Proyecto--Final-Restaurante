package co.edu.uniquindio.poo.PaymentMethodAdapter;

public class CashPaymentAdapter implements PaymentMethod{
    private CashPayment cash;

    public CashPaymentAdapter(CashPayment cash) {
        this.cash = cash;
    }

    @Override
    public void pay(double amount) {
        cash.payInCash(amount);
    }
    
}
