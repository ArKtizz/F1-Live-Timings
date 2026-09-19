package org.example;

import org.example.model.Driver;
import org.example.model.Team;
import org.example.model.Track;
import org.example.util.TimeFormatter;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        Driver verstappen = new Driver(3, "VER", Team.REDBULL);

        System.out.println("MAX VERSTAPPEN");
        System.out.println("Short name: "+verstappen.shortName());
        System.out.println("Team: "+verstappen.assignedTeam());
        System.out.println("Team modifier: "+verstappen.assignedTeam().getTimeModifier());

        Track suzuka = new Track("Suzuka", Duration.ofMillis(31500), Duration.ofMillis(40200), Duration.ofMillis(18100));

        System.out.println("SUZUKA\n"+"First sector: "+TimeFormatter.format(suzuka.firstSector()));
        System.out.println("Second sector: "+TimeFormatter.format(suzuka.secondSector()));
        System.out.println("Third sector: "+TimeFormatter.format(suzuka.thirdSector()));

        System.out.println("Estimated full lap time: "+TimeFormatter.format(TimeFormatter.fullLapTime(suzuka)));


    }
}