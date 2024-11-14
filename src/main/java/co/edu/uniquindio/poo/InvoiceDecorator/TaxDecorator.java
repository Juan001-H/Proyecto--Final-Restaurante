package co.edu.uniquindio.poo.InvoiceDecorator;

import co.edu.uniquindio.poo.PaymentMethodAdapter.PaymentMethod;

public class TaxDecorator extends InvoiceDecorator{

    private double taxPercentage;
    
    public TaxDecorator(InvoiceComponent decoratedInvoice, double taxPercentage) {
        super(decoratedInvoice);
        this.taxPercentage = taxPercentage;
    }

    @Override
    public double getTotalAmount() {
        return decoratedInvoice.getTotalAmount() * (1 + taxPercentage / 100);
    }

    @Override
    public void showDetails() {
        decoratedInvoice.showDetails();
        System.out.println("Tax (" + taxPercentage + "%): $" + (decoratedInvoice.getTotalAmount() * taxPercentage/100));
    }

    @Override
    public void payInvoice(PaymentMethod payment) {
        payment.pay(getTotalAmount());
    }
}
