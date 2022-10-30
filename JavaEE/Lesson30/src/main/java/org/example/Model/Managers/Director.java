package org.example.Model.Managers;

import org.example.Model.Executors.Executor;

import java.util.List;

public class Director implements Manager {
    private List<DeputyDirector> deputyDirectorList;
    @Override
    public boolean sendWork() {
        for (DeputyDirector deputyDirector : deputyDirectorList) {
            if (deputyDirector.sendWork()) {
                return true;
            }
        }
        return false;
    }
}
