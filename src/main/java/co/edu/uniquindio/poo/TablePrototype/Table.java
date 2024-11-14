package co.edu.uniquindio.poo.TablePrototype;

public class Table implements Prototype {
    private String tableNumber;
    private int seat;
    private boolean isAvailable;

    public Table(int seat, boolean isAvailable, String tableNumber) {
        this.seat = seat;
        this.isAvailable = isAvailable;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public Table clone() {
        return new Table(this.seat, this.isAvailable, this.tableNumber);
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void showDetails() {
        System.out.println(
                "table Number: " + tableNumber + ", number of seats: " + seat + ", is available : " + isAvailable);
    }

}
