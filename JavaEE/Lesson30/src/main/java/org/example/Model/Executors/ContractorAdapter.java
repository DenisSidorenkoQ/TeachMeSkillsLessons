package org.example.Model.Executors;

import lombok.Builder;

@Builder
public class ContractorAdapter extends Employee {
    @Override
    public boolean execute() {
        System.out.println("Let's do this");
        return true;
    }
}
