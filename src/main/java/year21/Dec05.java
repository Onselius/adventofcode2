package year21;

import util.ReadFile;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Dec05 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;

    public Dec05() {
    }

    protected long part1()
    {
        this.grid = new HashMap<>();
        lines.stream()
                .map(e -> e.replace(" -> ", ","))
                .forEach(this::addHorizontalPoint);

        return getOverlaps();
    }

    protected long part2()
    {
        this.grid = new HashMap<>();
        lines.stream()
                .map(e -> e.replace(" -> ", ","))
                .peek(this::addHorizontalPoint)
                .forEach(this::addDiagonalPoint);

        return getOverlaps();
    }

    private long getOverlaps()
    {

        return grid.values()
                .stream()
                .filter(e -> e > 1)
                .count();
    }

    private void addHorizontalPoint(String points)
    {
        int[] numbers = Arrays.stream(points.split(",")).mapToInt(Integer::parseInt).toArray();
        int x1 = numbers[0];
        int x2 = numbers[2];
        int y1 = numbers[1];
        int y2 = numbers[3];
        int value = this.grid.getOrDefault(List.of(x1, y1), 0);
        if (x1 == x2)
        {
            this.grid.put(List.of(x1, y1), value + 1);
            while (y1 != y2)
            {
                if (y1 > y2)
                {
                    y1--;
                }
                else
                {
                    y1++;
                }
                value = this.grid.getOrDefault(List.of(x1, y1), 0);
                this.grid.put(List.of(x1, y1), value + 1);
            }
            return;
        }
        if (y1 == y2)
        {
            this.grid.put(List.of(x1, y1), value + 1);
            while (x1 != x2)
            {
                if (x1 > x2)
                {
                    x1--;
                }
                else
                {
                    x1++;
                }
                value = this.grid.getOrDefault(List.of(x1, y1), 0);
                this.grid.put(List.of(x1, y1), value + 1);
            }
        }
    }

    private void addDiagonalPoint(String points)
    {
        int[] numbers = Arrays.stream(points.split(",")).mapToInt(Integer::parseInt).toArray();
        int x1 = numbers[0];
        int x2 = numbers[2];
        int y1 = numbers[1];
        int y2 = numbers[3];
        int value = this.grid.getOrDefault(List.of(x1, y1), 0);
        if (x1 != x2 && y1 != y2)
        {
            this.grid.put(List.of(x1, y1), value + 1);
            while (y1 != y2)
            {
                y1 = y1 > y2 ? y1 - 1 : y1 + 1;
                x1 = x1 > x2 ? x1 - 1 : x1 + 1;
                value = this.grid.getOrDefault(List.of(x1, y1), 0);
                this.grid.put(List.of(x1, y1), value + 1);
            }
        }
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
