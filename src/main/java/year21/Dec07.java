package year21;

import util.ReadFile;

import java.net.URL;
import java.util.*;

public class Dec07 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;

    public Dec07() {
    }

    protected long part1()
    {
        int[] input = Arrays.stream(lines.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, HashMap<Integer, Integer>> positions = new HashMap<>();
        OptionalInt max = Arrays.stream(input).max();
        OptionalInt min = Arrays.stream(input).min();

        HashMap<Integer, Integer> diffs = new HashMap<>();
        for (int i = min.orElse(0); i < max.orElse(0); i++)
        {
            int sum = 0;
            for (int value : input)
            {
                sum += Math.abs(i - value);
            }
            diffs.put(i, sum);
        }

        OptionalInt minValue = diffs.values().stream().mapToInt(Integer::valueOf).min();

        return minValue.orElse(0);
    }

    protected long part2()
    {
        int[] input = Arrays.stream(lines.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, HashMap<Integer, Integer>> positions = new HashMap<>();
        OptionalInt max = Arrays.stream(input).max();
        OptionalInt min = Arrays.stream(input).min();

        HashMap<Integer, Integer> diffs = new HashMap<>();
        for (int i = min.orElse(0); i < max.orElse(0); i++)
        {
            int sum = 0;
            for (int value : input)
            {
                sum += getFuel(Math.abs(i - value));
            }
            diffs.put(i, sum);
        }

        OptionalInt minValue = diffs.values().stream().mapToInt(Integer::valueOf).min();

        return minValue.orElse(0);
    }

    private int getFuel(int value)
    {
        int sum = 0;
        for (int i = 1; i <= value; i++)
        {
            sum += i;
        }
        return sum;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void updateLinesFromFilename(String filename)
    {
        URL url  = getClass().getResource(filename);
        this.lines = ReadFile.getTextFromFile(url.getPath());
    }

    public HashMap<List<Integer>, Integer> getGrid() {
        return grid;
    }
}
