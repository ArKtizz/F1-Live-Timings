package org.example;

import org.example.model.Driver;
import org.example.model.Team;
import org.example.model.Track;
import org.example.util.TimeFormatter;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        Driver verstappen = new Driver(3, "VER", Team.REDBULL);

        System.out.println("MAX VERSTAPPEN\nTeam: "+verstappen.assignedTeam()+"\nShort name: "+verstappen.shortName()+"\nModifier: "+verstappen.assignedTeam().getTimeModifier());

        Track suzuka = new Track("Suzuka", Duration.ofMillis(31500), Duration.ofMillis(40200), Duration.ofMillis(18100));

        System.out.println("SUZUKA\n"+"First sector: "+suzuka.firstSector()+"\nSecond sector: "+suzuka.secondSector()+"\nThirdSector: "+suzuka.thirdSector());

        System.out.println(TimeFormatter.format(suzuka.firstSector()));

    }
}