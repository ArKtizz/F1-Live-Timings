package org.example.service;

import org.example.model.Driver;
import org.example.model.Lap;
import org.example.util.TimeFormatter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LiveTimingBoard {

    private final Map<Driver, List<Lap>> board = new ConcurrentHashMap<>();

    public void updateLap(Driver driver, Lap lap) {
        List<Lap> laps = board.computeIfAbsent(driver, driverKey -> new CopyOnWriteArrayList<>());
        laps.add(lap);
    }

    public void printBoard() {
        var sortedBoard = board.entrySet().stream().sorted(Comparator.comparing(entry -> entry.getValue().getLast().getLapTime())).toList();
        int number = 1;

        for(Map.Entry<Driver, List<Lap>> entry : sortedBoard) {
            Driver driver = entry.getKey();
            Lap lap = entry.getValue().getLast();

            System.out.println(number + ". " + driver.shortName()+": "+ TimeFormatter.format(lap.getLapTime()));
            number++;
        }
    }
}
