package co.edu.uniquindio.poo.ChainOfResponsibilityValidation;

public abstract class ComplaintHandler {
    protected ComplaintHandler nextHandler;

    public void setNextHandler(ComplaintHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handleComplaint(String complaint);
}
