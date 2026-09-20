package org.example.service;

import org.example.model.Driver;
import org.example.model.Lap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LiveTimingBoard {

    private final Map<Driver, Lap> board = new ConcurrentHashMap<>();

    public void updateLap(Driver driver, Lap lap) {
        board.put(driver, lap);
    }
}
