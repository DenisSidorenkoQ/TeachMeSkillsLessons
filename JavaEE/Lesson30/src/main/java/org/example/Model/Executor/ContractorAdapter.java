package org.example.Model.Executor;

import lombok.Builder;
import org.example.Model.OrganizationMember;

@Builder
public class ContractorAdapter implements OrganizationMember {
    private Contractor contractor;
    @Override
    public boolean executeTask(String task) {
        return contractor.doWork(task);
    }
}
