package co.edu.uniquindio.poo.ChainOfResponsibilityValidation;

public class WaiterHandler extends ComplaintHandler {

    @Override
    public void handleComplaint(String complaint) {
        if (complaint.equalsIgnoreCase("minor Complaint")) {
            System.out.println("Waiter: I handled the customer complaint.");
        } else {
            if (nextHandler != null) {
                nextHandler.handleComplaint(complaint);
            }

        }
    }
}
