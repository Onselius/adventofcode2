package year21;

import util.ReadFile;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dec11 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;

    public Dec11() {
    }

    protected long part1(int flashes)
    {
        this.grid = ReadFile.populateGrid(this.lines);

        long numberOfFlashes = 0;
        for (int i = 0; i < flashes; i++)
        {
            numberOfFlashes += increaseStep();
        }

        return numberOfFlashes;
    }

    private long increaseStep()
    {
        long numberOfFlashes = 0;
        Set<List<Integer>> flashed = new HashSet<>();
        for (int y = 0; y < lines.size(); y++)
        {
            String[] line = lines.get(y).split("");
            for (int x = 0; x < line.length; x++)
            {
                List<Integer> position = List.of(y, x);
                if (flashed.contains(position))
                {
                    continue;
                }
                int value = grid.get(position) + 1;
                if (value > 9)
                {
                    grid.put(position, 0);
                    flashed.add(position);
                    numberOfFlashes++;
                    numberOfFlashes += flashPosition(position, flashed);
                }
                else
                {
                    grid.put(position, value);
                }
            }
        }

        return numberOfFlashes;
    }

    private long flashPosition(List<Integer> position, Set<List<Integer>> flashed)
    {
        int[][] steps = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        List<Integer> neighbourPosition;
        long numberOfFlashes = 0;
        for (int[] step : steps)
        {
            neighbourPosition = List.of(position.get(0) + step[0], position.get(1) + step[1]);
            if (flashed.contains(neighbourPosition) || !grid.containsKey(neighbourPosition))
            {
                continue;
            }
            int value = grid.get(neighbourPosition) + 1;
            if (value > 9)
            {
                grid.put(neighbourPosition, 0);
                flashed.add(neighbourPosition);
                numberOfFlashes++;
                numberOfFlashes += flashPosition(neighbourPosition, flashed);
            }
            else
            {
                grid.put(neighbourPosition, value);
            }
        }
        return numberOfFlashes;
    }

    protected long part2()
    {
        this.grid = ReadFile.populateGrid(this.lines);
        long step = 1;
        long numberOfFlashes = 0;
        while (true)
        {
            numberOfFlashes = increaseStep();

            if (numberOfFlashes == 100)
            {
                break;
            }
            step++;
        }
        return step;
    }

    protected void printGrid()
    {
        for (int y = 0; y < lines.size(); y++)
        {
            int length = lines.get(0).length();
            for (int x = 0; x < length; x++)
            {
                List<Integer> position = List.of(y, x);
                System.out.print(grid.get(position));
            }
            System.out.println();
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
