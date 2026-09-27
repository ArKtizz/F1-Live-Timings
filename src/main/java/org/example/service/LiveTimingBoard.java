package org.example.service;

import org.example.model.Driver;
import org.example.model.Lap;
import org.example.util.TimeFormatter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LiveTimingBoard {

    private final Map<Driver, Lap> board = new ConcurrentHashMap<>();

    public void updateLap(Driver driver, Lap lap) {
        board.put(driver, lap);
    }

    public void printBoard() {
        int number = 1;
        for(Map.Entry<Driver, Lap> entry : board.entrySet()) {
            Driver driver = entry.getKey();
            Lap lap = entry.getValue();

            System.out.println(number + ". " + driver.shortName()+": "+ TimeFormatter.format(lap.getLapTime()));
            number++;
        }
    }
}
