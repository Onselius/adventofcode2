package year23;

import util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dec06 {
    private List<String> lines;

    public Dec06() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        int[] timeArray = Arrays.stream(lines.get(0).replaceAll(".*:\\s+", "").split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] distanceArray = Arrays.stream(lines.get(1).replaceAll(".*:\\s+", "").split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int winnings = 1;
        for (int i = 0; i < timeArray.length; i++)
        {
            int time = timeArray[i];
            int distance = distanceArray[i];
            int win = 0;

            for (int speed = 1; speed < time - 1; speed++)
            {
                if (speed * (time - speed) > distance)
                {
                    win++;
                }
            }

            winnings *= win;
        }

        stopWatch.stopTime();
        return winnings;
    }

    protected int part2()
    {
        StopWatch stopWatch = new StopWatch();

        long time = Long.parseLong(lines.get(0).replaceAll(".*:\\s+", "").replaceAll("\\s+", ""));
        long distance = Long.parseLong(lines.get(1).replaceAll(".*:\\s+", "").replaceAll("\\s+", ""));

        int win = 0;

        for (long speed = 1; speed < time - 1; speed++)
        {
            if (speed * (time - speed) > distance)
            {
                win++;
            }
        }

        stopWatch.stopTime();
        return win;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
