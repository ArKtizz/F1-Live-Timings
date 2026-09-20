package org.example.model;

public enum Team {
    MERCEDES(0.5),
    FERRARI(0.6),
    MCLAREN(0.65),
    REDBULL(0.65),
    RACINGBULLS(1.15),
    ALPINE(1.2),
    HAAS(1.3),
    AUDI(1.3),
    WILLIAMS(1.5),
    ASTONMARTIN(1.8),
    CADILLAC(2);

    private final double timeModifier;

    Team(double timeModifier) {
        this.timeModifier = timeModifier;
    }

    public double getTimeModifier() {
        return timeModifier;
    }
}
