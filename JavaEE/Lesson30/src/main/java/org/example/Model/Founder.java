package org.example.Model;

import lombok.Builder;
import org.example.Model.Observer.TaxOffice;

@Builder
public class Founder {
    OrganizationMember director;

    public void sendTask(String task) {
        director.executeTask(task);
    }
}
