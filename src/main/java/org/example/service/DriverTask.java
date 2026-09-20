package org.example.service;

import org.example.model.Driver;
import org.example.model.Lap;
import org.example.model.Track;
import org.example.util.TimeFormatter;

public class DriverTask implements Runnable {

    private final Driver driver;
    private final Track track;
    private final LiveTimingBoard timingBoard;

    public DriverTask(Driver driver, Track track, LiveTimingBoard timingBoard) {
        this.driver = driver;
        this.track = track;
        this.timingBoard = timingBoard;
    }

    @Override
    public void run() {
        try {
            System.out.println("Driver "+driver.shortName()+" is starting a lap.");
            Lap newLap = new Lap();

            newLap.setFirstSector(Simulator.simulateSectorTime(track.firstSector(), driver.assignedTeam().getTimeModifier()));
            System.out.println(driver.shortName()+" First sector: "+TimeFormatter.format(newLap.getFirstSector()));
            timingBoard.updateLap(driver, newLap);

            Thread.sleep(2000);

            newLap.setSecondSector(Simulator.simulateSectorTime(track.secondSector(), driver.assignedTeam().getTimeModifier()));
            System.out.println(driver.shortName()+" Second sector: "+TimeFormatter.format(newLap.getSecondSector()));
            timingBoard.updateLap(driver, newLap);

            Thread.sleep(2000);

            newLap.setThirdSector(Simulator.simulateSectorTime(track.thirdSector(), driver.assignedTeam().getTimeModifier()));
            System.out.println(driver.shortName()+" Third sector: "+TimeFormatter.format(newLap.getThirdSector()));
            timingBoard.updateLap(driver, newLap);

            System.out.println(driver.shortName()+" Full lap: "+TimeFormatter.format(newLap.getLapTime()));
        } catch (InterruptedException e) {
            System.out.println("Lap by "+driver.shortName() + " is cancelled.");
        }

    }

}
