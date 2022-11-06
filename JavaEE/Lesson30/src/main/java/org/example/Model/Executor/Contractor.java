package org.example.Model.Executor;

import lombok.Builder;
import org.example.Model.State.OrganizationMemberState;

@Builder
public class Contractor {
    private OrganizationMemberState organizationMemberState;
    public boolean doWork(String task) {
        if (organizationMemberState.getState()) {
            System.out.println("Doing work: " + task);
            return true;
        } else {
            organizationMemberState.printState();
        }
        return false;
    }
}
