package org.example.Model.Managers;

import org.example.Model.Executors.Executor;

import java.util.List;

public class DeputyDirector implements Manager {
    private List<Administrator> administratorList;
    @Override
    public boolean sendWork() {
        for (Administrator administrator : administratorList) {
            if (administrator.sendWork()) {
                return true;
            }
        }
        return false;
    }
}
