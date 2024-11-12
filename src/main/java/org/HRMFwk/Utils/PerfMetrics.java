package org.HRMFwk.Utils;

import java.util.HashMap;
import java.util.Map;

public class PerfMetrics {
    private Map<String, Long> startTimes = new HashMap<>();

    public void start(String key) {
        startTimes.put(key, System.currentTimeMillis());
    }

    public void end(String key) {
        Long startTime = startTimes.get(key);
        if (startTime != null) {
            long duration = System.currentTimeMillis() - startTime;
            System.out.println(key + " took " + duration + "ms");
        }
    }
}
