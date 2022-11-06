package org.example.Model.Observer;

import lombok.Builder;

import java.util.List;

@Builder
public class TaxOffice implements Observer {
    List<String> taskList;

    @Override
    public void notify(String taskResult) {
        taskList.add(taskResult);
    }
}
