package org.example.Model;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Builder
@Slf4j
public class Founder implements TaxOfficeObserver {
    @Override
    public void logListener() {
        log.info("Sent the work to the director");
    }
}
