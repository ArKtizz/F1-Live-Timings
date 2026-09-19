package org.example.model;

import java.time.Duration;

public record Track(String name, Duration firstSector, Duration secondSector, Duration thirdSector) {
}
