package org.example.Model;

import lombok.Builder;
import org.example.Model.Manager.Director;

@Builder
public class Organization {
    private Founder founder;
    private TaxOffice taxOffice;

    public void createNewTask(String task) {
        founder.sendTask(task, taxOffice);
    }
}
