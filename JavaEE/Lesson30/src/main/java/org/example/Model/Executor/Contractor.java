package org.example.Model.Executor;

import lombok.Builder;
import org.example.Model.State.OrganizationMemberState;

@Builder
public class Contractor {
    public boolean doWork(String task) {
        System.out.println("Work is done: " + task);
        return true;
    }
}
