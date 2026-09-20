    package org.example;

    import org.example.model.Driver;

    import org.example.model.Team;
    import org.example.model.Track;
    import org.example.service.DriverTask;
    import org.example.service.LiveTimingBoard;
    import org.example.util.TimeFormatter;

    import java.time.Duration;

    public class Main {
        public static void main(String[] args) throws InterruptedException {

            Driver verstappen = new Driver(3, "VER", Team.REDBULL);
            Driver leclerc = new Driver(16, "LEC", Team.FERRARI);
            Driver alonso = new Driver(14, "ALO", Team.ASTONMARTIN);

            Track suzuka = new Track("Suzuka", Duration.ofMillis(31500), Duration.ofMillis(40200), Duration.ofMillis(18100));

            System.out.println("Suzuka estimated full lap time: "+TimeFormatter.format(TimeFormatter.fullLapTime(suzuka)));

            LiveTimingBoard timingBoard = new LiveTimingBoard();

            DriverTask lapVER = new DriverTask(verstappen, suzuka, timingBoard);
            DriverTask lapLEC = new DriverTask(leclerc, suzuka, timingBoard);
            DriverTask lapALO = new DriverTask(alonso, suzuka, timingBoard);

            Thread thread1 = new Thread(lapVER);
            Thread thread2 = new Thread(lapLEC);
            Thread thread3 = new Thread(lapALO);

            thread1.start();
            thread2.start();
            thread3.start();

        }
    }