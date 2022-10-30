package org.example.Model.Managers;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.example.Model.TaxOfficeObserver;

import java.util.List;

@Builder
@Slf4j
public class DeputyDirector implements Manager, TaxOfficeObserver {
    private List<Administrator> administratorList;

    @Override
    public void logListener() {
        log.info("Sent the work to the administrator");
    }
    @Override
    public boolean sendWork() {
        for (Administrator administrator : administratorList) {
            logListener();
            if (administrator.sendWork()) {
                return true;
            }
        }
        return false;
    }
}
