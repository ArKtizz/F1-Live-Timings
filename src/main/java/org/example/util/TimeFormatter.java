package org.example.util;

import org.example.model.Track;

import java.time.Duration;

public class TimeFormatter {
    public static String format(Duration duration) {
        int minutes = duration.toMinutesPart();
        int seconds = duration.toSecondsPart();
        int miliSeconds = duration.toMillisPart();

        String formattedText = String.format("%d:%02d:%03d", minutes, seconds, miliSeconds);

        return formattedText;
    }

    public static Duration fullLapTime(Track track) {
        return track.firstSector()
                .plus(track.secondSector())
                .plus(track.thirdSector());

    }
}
