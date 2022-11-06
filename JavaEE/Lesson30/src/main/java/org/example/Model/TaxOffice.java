package org.example.Model;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class TaxOffice {
    List<String> taskList = new ArrayList<>();

    public void addTask(String task) {
        taskList.add(task);
    }
}
