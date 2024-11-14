package co.edu.uniquindio.poo.InvoiceDecorator;

import co.edu.uniquindio.poo.PaymentMethodAdapter.PaymentMethod;

public class TipDecorator extends InvoiceDecorator {
    private double tipPercentage;

    public TipDecorator(InvoiceComponent decoratedInvoice, double tipPercentage) {
        super(decoratedInvoice);
        this.tipPercentage = tipPercentage;
    }

    @Override
    public double getTotalAmount() {
        return decoratedInvoice.getTotalAmount() * (1.0 + tipPercentage / 100);
    }

    @Override
    public void showDetails() {
        decoratedInvoice.showDetails();
        System.out.println("Tip (" + tipPercentage + "%): $" + (decoratedInvoice.getTotalAmount() * tipPercentage/100)+ " Price Plus Tip: $"+ getTotalAmount()); 
    }

    @Override
    public void payInvoice(PaymentMethod payment) {
        payment.pay(getTotalAmount());
    }
}
