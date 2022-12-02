package year21;

import util.ReadFile;

import java.net.URL;
import java.util.*;

public class Dec15 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;
    private int height;
    private int width;

    public Dec15() {
    }

    protected long part1()
    {
        this.grid = ReadFile.populateGrid(lines);
        width = lines.get(0).length();
        height = lines.size();
        List<Integer> endPoint = List.of(width - 1 , height - 1);

        HashMap<List<Integer>, Integer> visited = new HashMap<>();
        visited.put(List.of(0, 0), 0);
        int currentRisk;
        int[][] steps = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0,0));
        while (queue.size() > 0)
        {
            List<Integer> point = queue.poll();
            currentRisk = visited.get(point);
            for (int[] step : steps)
            {
                List<Integer> neighbour = List.of(point.get(0) + step[0], point.get(1) + step[1]);
                if (!grid.containsKey(neighbour)) continue;
                int newRisk = currentRisk + grid.get(neighbour);
                if (visited.getOrDefault(neighbour, Integer.MAX_VALUE) > newRisk)
                {
                    visited.put(neighbour, newRisk);
                    queue.add(neighbour);
                }
            }
        }

        long finalRisk = visited.get(endPoint);

        return finalRisk;
    }

    protected long part2()
    {
        this.grid = ReadFile.populateGrid(lines);
        int width = (lines.get(0).length() * 5) - 1;
        int height = width;
        List<Integer> endPoint = List.of(width, height);

        HashMap<List<Integer>, Integer> visited = new HashMap<>();
        visited.put(List.of(0, 0), 0);
        int currentRisk;
        int[][] steps = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0,0));
        while (queue.size() > 0)
        {
            List<Integer> point = queue.poll();
            currentRisk = visited.get(point);
            for (int[] step : steps)
            {
                List<Integer> neighbour = List.of(point.get(0) + step[0], point.get(1) + step[1]);
                if (neighbour.get(0) < 0 || neighbour.get(0) > width) continue;
                if (neighbour.get(1) < 0 || neighbour.get(1) > height) continue;
                int newRisk = currentRisk + getRisk(neighbour);
                if (visited.getOrDefault(neighbour, Integer.MAX_VALUE) > newRisk)
                {
                    visited.put(neighbour, newRisk);
                    queue.add(neighbour);
                }
            }
        }

        long finalRisk = visited.get(endPoint);

        return finalRisk;
    }

    private int getRisk(List<Integer> point)
    {
        int modulus = this.lines.size();
        int value = grid.get(List.of(point.get(0) % modulus, point.get(1) % modulus));
        List<Integer> original = List.of(point.get(0) % modulus, point.get(1) % modulus);
        value += point.get(0) / modulus;
        value += point.get(1) / modulus;

        if (value > 9)
        {
            value = value % 9;
        }

        return value;
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
