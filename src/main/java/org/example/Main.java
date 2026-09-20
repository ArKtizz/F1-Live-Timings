package org.example;

import org.example.model.Driver;
import org.example.model.Lap;
import org.example.model.Team;
import org.example.model.Track;
import org.example.service.Simulator;
import org.example.util.TimeFormatter;

import java.sql.Time;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        Driver verstappen = new Driver(3, "VER", Team.REDBULL);

        System.out.println("MAX VERSTAPPEN");
        System.out.println("Short name: "+verstappen.shortName());
        System.out.println("Team: "+verstappen.assignedTeam());
        System.out.println("Team modifier: "+verstappen.assignedTeam().getTimeModifier());

        Track suzuka = new Track("Suzuka", Duration.ofMillis(31500), Duration.ofMillis(40200), Duration.ofMillis(18100));

        System.out.println("Estimated full lap time: "+TimeFormatter.format(TimeFormatter.fullLapTime(suzuka)));

        Lap newLap = new Lap();
        newLap.setFirstSector(Simulator.simulateSectorTime(suzuka.firstSector(), verstappen.assignedTeam().getTimeModifier()));
        System.out.println(TimeFormatter.format(newLap.getFirstSector()));
        newLap.setSecondSector(Simulator.simulateSectorTime(suzuka.secondSector(), verstappen.assignedTeam().getTimeModifier()));
        System.out.println(TimeFormatter.format(newLap.getSecondSector()));
        newLap.setThirdSector(Simulator.simulateSectorTime(suzuka.thirdSector(), verstappen.assignedTeam().getTimeModifier()));
        System.out.println(TimeFormatter.format(newLap.getThirdSector()));
        System.out.println("Full lap: "+TimeFormatter.format(newLap.getLapTime()));

    }
}