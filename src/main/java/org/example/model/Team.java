package org.example.model;

public enum Team {
    MERCEDES(0.96),
    FERRARI(0.97),
    MCLAREN(0.98),
    REDBULL(1),
    RACINGBULLS(1.02),
    ALPINE(1.02),
    HAAS(1.04),
    AUDI(1.04),
    WILLIAMS(1.05),
    ASTONMARTIN(1.07),
    CADILLAC(1.1);

    private final double timeModifier;

    Team(double timeModifier) {
        this.timeModifier = timeModifier;
    }

    public double getTimeModifier() {
        return timeModifier;
    }
}
