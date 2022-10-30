package org.example.Model.Managers;

import org.example.Model.Executors.Executor;

import java.util.List;

public class Administrator implements Manager {
    private List<Executor> executorList;
    @Override
    public boolean sendWork() {
        for (Executor executor : executorList) {
            if (executor.execute()) {
                return true;
            }
        }
        return false;
    }
}
