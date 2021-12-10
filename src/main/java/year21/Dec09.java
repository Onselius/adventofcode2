package year21;

import util.ReadFile;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Dec09 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;
    private HashSet<List<Integer>> visited;

    public Dec09() {
        this.grid = new HashMap<>();
        this.visited = new HashSet<>();
    }

    protected long part1()
    {
        this.grid = populateGrid();

        int[][] steps = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        int riskLevel = 0;
        for (int y = 0; y < lines.size(); y++)
        {
            for (int x = 0; x < lines.get(0).length(); x++)
            {
                boolean isLowPoint = true;
                List<Integer> position = List.of(y, x);
                int positionValue = grid.get(position);
                int border;
                for (int[] step : steps)
                {
                    border = grid.getOrDefault(List.of(y + step[0], x + step[1]), 10);
                    if (border <= positionValue)
                    {
                        isLowPoint = false;
                    }
                }
                if (isLowPoint)
                {
                    riskLevel += positionValue + 1;
                }
            }
        }

        return riskLevel;
    }

    protected long part2()
    {
        this.grid = populateGrid();

        List<Integer> sizes = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++)
        {
            for (int x = 0; x < lines.get(0).length(); x++)
            {
                List<Integer> position = List.of(y, x);
                int positionValue = grid.get(position);
                if (positionValue == 9 || visited.contains(position))
                {
                    continue;
                }
                visited.add(position);
                int size = countNeighbours(position);
                sizes.add(size);
            }
        }

        Collections.sort(sizes);
        Collections.reverse(sizes);

        return (long) sizes.get(0) * sizes.get(1) * sizes.get(2);
    }

    private int countNeighbours(List<Integer> position)
    {
        int[][] steps = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int positionValue = grid.getOrDefault(position, 10);
        if (positionValue == 10)
        {
            return 0;
        }
        int neighbour;
        int numberOfNeighbours = 1;
        List<Integer> neighbourPosition;
        for (int[] step : steps)
        {
            neighbourPosition = List.of(position.get(0) + step[0], position.get(1) + step[1]);
            neighbour = grid.getOrDefault(neighbourPosition, 10);
            if (neighbour >= 9 || visited.contains(neighbourPosition))
            {
                continue;
            }
            visited.add(neighbourPosition);
            numberOfNeighbours += countNeighbours(neighbourPosition);
        }

        return numberOfNeighbours;
    }

    private HashMap<List<Integer>, Integer> populateGrid()
    {
        HashMap<List<Integer>, Integer> grid = new HashMap<>();
        for (int y = 0; y < lines.size(); y++)
        {
            String[] line = lines.get(y).split("");
            for (int x = 0; x < lines.get(0).length(); x++)
            {
                grid.put(List.of(y, x), Integer.parseInt(line[x]));
            }
        }
        return grid;
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
