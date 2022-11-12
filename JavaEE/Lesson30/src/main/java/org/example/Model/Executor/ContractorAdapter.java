package org.example.Model.Executor;

import lombok.Builder;
import org.example.Model.Observer.ObservableOrganizationMember;

@Builder
public class ContractorAdapter extends ObservableOrganizationMember {
    private Contractor contractor;
    @Override
    public boolean executeTask(String task) {
        notifyObservers(task);
        return contractor.doWork(task);
    }
}
