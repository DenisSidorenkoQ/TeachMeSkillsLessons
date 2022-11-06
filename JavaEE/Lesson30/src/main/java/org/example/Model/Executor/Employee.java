package org.example.Model.Executor;

import lombok.Builder;
import org.example.Model.Observer.Observable;
import org.example.Model.Observer.ObservableOrganizationMember;
import org.example.Model.Observer.Observer;
import org.example.Model.OrganizationMember;
import org.example.Model.State.OrganizationMemberState;

@Builder
public class Employee extends ObservableOrganizationMember implements OrganizationMember, Observable {
    private OrganizationMemberState organizationMemberState;
    @Override
    public boolean execute(String task) {
        notifyObservers(task);
        System.out.println("Work is done: " + task);
        return true;
    }
    @Override
    public boolean executeTask(String task) {
        return organizationMemberState.executeTask(this, task);
    }

    @Override
    public void registerObserver(Observer observer) {
        addObserver(observer);
    }
}
