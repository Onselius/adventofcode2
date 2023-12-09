package year23;

import util.StopWatch;

import java.util.Arrays;
import java.util.List;

public class Dec09 {
    private List<String> lines;

    public Dec09() {
    }

    protected long part1()
    {
        StopWatch stopWatch = new StopWatch();

        long answer = 0;
        for (String line: lines)
        {
            int[] intLine = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
            int nextValue = calculateDiff(intLine);
            answer += nextValue;
        }

        stopWatch.stopTime();
        return answer;
    }

    private int calculateDiff(int[] line)
    {
        int[] newLine = new int[line.length - 1];

        for (int i = 0; i < line.length - 1; i++)
        {
            newLine[i] = line[i+1] - line[i];
        }

        if (Arrays.stream(newLine).allMatch(x -> x == 0))
        {
            return line[line.length - 1];
        }
        else
        {
            return calculateDiff(newLine) + line[line.length - 1];
        }
    }

    protected long part2()
    {
        StopWatch stopWatch = new StopWatch();

        long answer = 0;
        for (String line: lines)
        {
            int[] intLine = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
            int nextValue = calculateDiff2(intLine);
            answer += nextValue;
        }

        stopWatch.stopTime();
        return answer;
    }

    private int calculateDiff2(int[] line)
    {
        int[] newLine = new int[line.length - 1];

        for (int i = 0; i < line.length - 1; i++)
        {
            newLine[i] = line[i+1] - line[i];
        }

        if (Arrays.stream(newLine).allMatch(x -> x == 0))
        {
            return line[0];
        }
        else
        {
            return line[0]  - calculateDiff2(newLine);
        }
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
