package org.example.service;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class Simulator {
    public static Duration simulateSectorTime(Duration baseSectorTime, double teamModifier) {
        long timeOffset = ThreadLocalRandom.current().nextLong(0, 200);

        return Duration.ofMillis((long)((baseSectorTime.toMillis() + timeOffset) * teamModifier));

    }
}
