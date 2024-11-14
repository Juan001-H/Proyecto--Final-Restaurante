package co.edu.uniquindio.poo.StatusObserver;

import java.util.ArrayList;
import java.util.List;

public class ObserverOrder {
    private List<Observer> observers = new ArrayList<>();
    private String status;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObservador(Observer observer) {
        observers.remove(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observador : observers) {
            observador.update(status);
        }
    }
}

