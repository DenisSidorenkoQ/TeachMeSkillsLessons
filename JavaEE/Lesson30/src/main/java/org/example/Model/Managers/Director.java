package org.example.Model.Managers;


import lombok.extern.slf4j.Slf4j;
import org.example.Model.TaxOfficeObserver;

import java.util.List;

@Slf4j
public class Director implements Manager, TaxOfficeObserver {
    private List<DeputyDirector> deputyDirectorList;

    @Override
    public void logListener() {
        log.info("Sent the work to the deputy director");
    }

    @Override
    public boolean sendWork() {
        for (DeputyDirector deputyDirector : deputyDirectorList) {
            logListener();
            if (deputyDirector.sendWork()) {
                return true;
            }
        }
        return false;
    }
}
