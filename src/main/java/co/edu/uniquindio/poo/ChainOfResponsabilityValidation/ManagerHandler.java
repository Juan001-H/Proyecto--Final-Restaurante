package co.edu.uniquindio.poo.ChainOfResponsabilityValidation;

public class ManagerHandler extends ComplaintHandler {

    @Override
    public void handleComplaint(String complaint) {
        System.out.println("Manager: I would handle this complaint personally");
    }
    
}
