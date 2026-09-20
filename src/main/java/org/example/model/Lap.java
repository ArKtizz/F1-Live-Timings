package org.example.model;

import java.time.Duration;

public class Lap {
    private Duration firstSector;
    private Duration secondSector;
    private Duration thirdSector;

    public Duration getFirstSector() {
        return firstSector;
    }

    public void setFirstSector(Duration firstSector) {
        this.firstSector = firstSector;
    }

    public Duration getSecondSector() {
        return secondSector;
    }

    public void setSecondSector(Duration secondSector) {
        this.secondSector = secondSector;
    }

    public Duration getThirdSector() {
        return thirdSector;
    }

    public void setThirdSector(Duration thirdSector) {
        this.thirdSector = thirdSector;
    }

    public Duration getLapTime() {

        Duration total = Duration.ZERO;

        if (this.firstSector != null) {
            total = total.plus(this.firstSector);
        }

        if (this.secondSector != null) {
            total = total.plus(this.secondSector);
        }

        if (this.thirdSector != null) {
            total = total.plus(this.thirdSector);
        }

        return total;
    }
}
