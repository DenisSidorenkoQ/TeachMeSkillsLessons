package org.example.Model.Manager;

import lombok.Builder;
import org.example.Model.Observer.Observable;
import org.example.Model.Observer.ObservableOrganizationMember;
import org.example.Model.Observer.Observer;
import org.example.Model.OrganizationMember;
import org.example.Model.State.OrganizationMemberState;

import java.util.List;

@Builder
public class DeputyDirector extends ObservableOrganizationMember implements OrganizationMember, Observable {
    private List<OrganizationMember> organizationMemberList;
    private OrganizationMemberState organizationMemberState;

    @Override
    public boolean execute(String task) {
        notifyObservers(task);
        for (OrganizationMember o : organizationMemberList) {
            return o.executeTask(task);
        }
        return false;
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
