package org.example.Model.Managers;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.example.Model.Executors.Executor;
import org.example.Model.TaxOfficeObserver;

import java.util.List;

@Builder
@Slf4j
public class Administrator implements Manager, TaxOfficeObserver {
    private List<Executor> executorList;

    @Override
    public void logListener() {
        log.info("Sent the work to the executor");
    }
    @Override
    public boolean sendWork() {
        for (Executor executor : executorList) {
            logListener();
            if (executor.execute()) {
                return true;
            }
        }
        return false;
    }
}
