package org.example.Model.Executor;

import lombok.Builder;
import org.example.Model.OrganizationMember;
import org.example.Model.State.OrganizationMemberState;

@Builder
public class Employee implements OrganizationMember {
    private OrganizationMemberState organizationMemberState;
    @Override
    public boolean executeTask(String task) {
        if (organizationMemberState.getState()) {
            System.out.println("Doing work" + task);
            return true;
        } else {
            organizationMemberState.printState();
        }
        return false;
    }
}
