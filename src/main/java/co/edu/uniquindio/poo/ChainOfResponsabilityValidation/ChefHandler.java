package co.edu.uniquindio.poo.ChainOfResponsabilityValidation;

public class ChefHandler extends ComplaintHandler{

    @Override
    public void handleComplaint(String complaint) {
        if (complaint.equalsIgnoreCase("food Complaint")) {
            System.out.println("Chef: I handled the customer complaint.");
        } else {
            if (nextHandler != null) {
                nextHandler.handleComplaint(complaint);
            }
        }
    }
    
}
