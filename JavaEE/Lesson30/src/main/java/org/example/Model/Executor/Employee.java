package org.example.Model.Executor;

import lombok.Builder;
import org.example.Model.Observer.ObservableOrganizationMember;
import org.example.Model.State.OrganizationMemberState;

@Builder
public class Employee extends ObservableOrganizationMember {
    private OrganizationMemberState organizationMemberState;
    @Override
    public boolean executeTask(String task) {
        notifyObservers(task);
        System.out.println("Work is done: " + task);
        return organizationMemberState.executeTask(this, task);
    }
}
