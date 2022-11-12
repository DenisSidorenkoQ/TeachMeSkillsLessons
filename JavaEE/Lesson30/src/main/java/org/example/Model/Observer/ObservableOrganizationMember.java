package org.example.Model.Observer;

import org.example.Model.Observer.Observer;
import org.example.Model.OrganizationMember;

import java.util.List;

public abstract class ObservableOrganizationMember implements OrganizationMember, Observable {
    private List<Observer> observerList;

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }
    public void notifyObservers(String task) {
        for (Observer observer : observerList) {
            observer.notify(task);
        }
    }

    public void registerObserver(Observer observer) {
        addObserver(observer);
    }
}
