package co.edu.uniquindio.poo.InvoiceDecorator;

import co.edu.uniquindio.poo.PaymentMethodAdapter.PaymentMethod;

public abstract class InvoiceDecorator implements InvoiceComponent{
    protected InvoiceComponent decoratedInvoice;

    public InvoiceDecorator(InvoiceComponent decoratedInvoice) {
        this.decoratedInvoice = decoratedInvoice;
    }

    @Override
    public double getTotalAmount() {
        return decoratedInvoice.getTotalAmount();
    }

    @Override
    public void showDetails() {
        decoratedInvoice.showDetails();
    }
    @Override
    public void payInvoice(PaymentMethod payment) {
        payment.pay(getTotalAmount());
    }
}
