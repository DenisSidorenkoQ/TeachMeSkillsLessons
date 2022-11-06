package org.example.Model.Executor;

import lombok.Builder;
import org.example.Model.Observer.Observable;
import org.example.Model.Observer.ObservableOrganizationMember;
import org.example.Model.Observer.Observer;
import org.example.Model.OrganizationMember;

@Builder
public class ContractorAdapter extends ObservableOrganizationMember implements OrganizationMember, Observable {
    private Contractor contractor;
    @Override
    public boolean executeTask(String task) {
        notifyObservers(task);
        return contractor.doWork(task);
    }

    @Override
    public boolean execute(String task) {
        return false;
    }

    @Override
    public void registerObserver(Observer observer) {
        addObserver(observer);
    }
}
