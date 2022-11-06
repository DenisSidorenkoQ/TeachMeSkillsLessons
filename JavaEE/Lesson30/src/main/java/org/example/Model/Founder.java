package org.example.Model;

import lombok.Builder;
import org.example.Model.Manager.Director;

@Builder
public class Founder {
    Director director;

    public void sendTask(String task, TaxOffice taxOffice) {
        director.executeTask(task);
    }
}
