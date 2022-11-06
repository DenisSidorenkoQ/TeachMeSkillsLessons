package org.example.Model.Manager;

import lombok.Builder;
import org.example.Model.Observer.ObservableOrganizationMember;
import org.example.Model.OrganizationMember;

import java.util.List;

@Builder
public class Manager extends ObservableOrganizationMember {
    private List<OrganizationMember> organizationMemberList;
    private Role role;

    @Override
    public boolean executeTask(String task) {
        notifyObservers(task);
        for (OrganizationMember o : organizationMemberList) {
            return o.executeTask(task);
        }
        return false;
    }
}
