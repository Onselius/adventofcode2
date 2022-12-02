package year21;

import util.ReadFile;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Dec13 {

    private List<String> lines;
    private HashSet<List<Integer>> grid;
    private List<Integer[]> instructions;

    public Dec13() {
    }

    protected long part1()
    {
        this.grid = parseCoordinates();
        this.instructions = parseInstructions();

        this.grid = fold(instructions.get(0));

        return grid.size();
    }

    protected long part2()
    {
        this.grid = parseCoordinates();
        this.instructions = parseInstructions();

        for (Integer[] direction : instructions)
        {
            this.grid = fold(direction);
        }
        printGrid();

        return grid.size();
    }

    private HashSet<List<Integer>> fold(Integer[] middle)
    {
        HashSet<List<Integer>> newGrid = new HashSet<>(this.grid);

        // FOLD Y
        if (middle[0] == 0)
        {
            for (int i = middle[1] - 1, j = middle[1] + 1; i >= 0; i--, j++)
            {
                for (List<Integer> point : this.grid)
                {
                    if (point.get(0) == j)
                    {
                        newGrid.add(List.of(i, point.get(1)));
                        newGrid.remove(point);
                    }
                }
            }
        }
        // FOLD X
        else
        {
            for (int i = middle[1] - 1, j = middle[1] + 1; i >= 0; i--, j++)
            {
                for (List<Integer> point : this.grid)
                {
                    if (point.get(1) == j)
                    {
                        newGrid.add(List.of(point.get(0), i));
                        newGrid.remove(point);
                    }
                }
            }
        }

        return newGrid;
    }

    private void printGrid()
    {
        int maxX = this.grid.stream()
                .map(e -> e.get(1))
                .max(Integer::compare)
                .get();

        int maxY = this.grid.stream()
                .map(e -> e.get(0))
                .max(Integer::compare)
                .get();

        for (int y = 0; y <= maxY; y++)
        {
            for (int x = 0; x <= maxX; x++)
            {
                List<Integer> point = List.of(y, x);
                if (this.grid.contains(point))
                {
                    System.out.print("#");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private HashSet<List<Integer>> parseCoordinates()
    {
        HashSet<List<Integer>> grid = new HashSet<>();
        for (String line : this.lines)
        {
            if (line.isEmpty()) break;

            String[] splitted = line.split(",");
            grid.add(
                    List.of(
                            Integer.parseInt(splitted[1]),
                            Integer.parseInt(splitted[0])
                    ));
        }

        return grid;
    }

    private List<Integer[]> parseInstructions()
    {
        List<Integer[]> instructions = new ArrayList<>();
        for (String line : this.lines)
        {
            if (line.contains(",")) continue;
            if (line.isEmpty()) continue;

            String[] splitted = line.split("=");
            if (splitted[0].endsWith("y"))
            {
                instructions.add(new Integer[]{0, Integer.parseInt(splitted[1])});
            }
            else
            {
                instructions.add(new Integer[]{1, Integer.parseInt(splitted[1])});
            }
        }

        return instructions;
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

    public HashSet<List<Integer>> getGrid() {
        return grid;
    }
}
