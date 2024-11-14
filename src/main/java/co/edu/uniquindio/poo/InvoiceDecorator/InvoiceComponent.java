package co.edu.uniquindio.poo.InvoiceDecorator;

import co.edu.uniquindio.poo.PaymentMethodAdapter.PaymentMethod;

public interface InvoiceComponent {
    void payInvoice(PaymentMethod payment);
    double getTotalAmount();
    void showDetails();
}
