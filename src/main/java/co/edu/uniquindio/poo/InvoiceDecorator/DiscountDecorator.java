package co.edu.uniquindio.poo.InvoiceDecorator;

import co.edu.uniquindio.poo.PaymentMethodAdapter.PaymentMethod;

public class DiscountDecorator extends InvoiceDecorator{
    private double discountPercentage;

    public DiscountDecorator(InvoiceComponent decoratedInvoice, double discountPercentage) {
        super(decoratedInvoice);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getTotalAmount() {
        return decoratedInvoice.getTotalAmount() * (1 - discountPercentage / 100);
    }

    @Override
    public void showDetails() {
        decoratedInvoice.showDetails();
        System.out.println("Discount (" + discountPercentage + "%): -$" + (decoratedInvoice.getTotalAmount() * discountPercentage/100));
    }

    @Override
    public void payInvoice(PaymentMethod payment) {
            payment.pay(getTotalAmount());
    }
}

