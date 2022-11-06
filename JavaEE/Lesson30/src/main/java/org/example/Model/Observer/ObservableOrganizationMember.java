package org.example.Model.Observer;

import org.example.Model.Observer.Observer;

import java.util.List;

public abstract class ObservableOrganizationMember {
    private List<Observer> observerList;

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }
    public void notifyObservers(String task) {
        for (Observer observer : observerList) {
            observer.notify(task);
        }
    }
}
