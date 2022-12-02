package year21;

import util.ReadFile;

import java.net.URL;
import java.util.*;

public class Dec20 {

    private List<String> lines;
    private HashMap<List<Integer>, Character> grid;
    private char[] enhancement;

    public Dec20() {
    }

    protected long part1(int iterations)
    {
        String line = lines.get(0);
        line = line.replace('.', '0');
        line = line.replace('#', '1');
        enhancement = line.toCharArray();
        lines.remove(1);
        lines.remove(0);
        grid = populateGrid(lines);
//        printGrid();

        for (int i = 0; i < iterations; i++)
        {
            char outside = i % 2 == 0 ? '0' : '1';
            grid = enhance(outside);
//            printGrid();
        }

        return getLitPoints();
    }

    protected long part2(int iterations)
    {
        String line = lines.get(0);
        line = line.replace('.', '0');
        line = line.replace('#', '1');
        enhancement = line.toCharArray();
        lines.remove(1);
        lines.remove(0);
        grid = populateGrid(lines);
//        printGrid();

        for (int i = 0; i < iterations; i++)
        {
            char outside = i % 2 == 0 ? '0' : '1';
            grid = enhance(outside);
//            System.out.println(getLitPoints());
//            printGrid();
        }

        return getLitPoints();
    }

    public HashMap<List<Integer>, Character> enhance(Character outside)
    {
        int minX = grid.keySet().stream()
            .map(e -> e.get(0))
            .min(Integer::compare)
            .get() - 1;

        int maxX = grid.keySet().stream()
                .map(e -> e.get(0))
                .max(Integer::compare)
                .get() + 1;

        int minY = grid.keySet().stream()
                .map(e -> e.get(1))
                .min(Integer::compare)
                .get() - 1;

        int maxY = grid.keySet().stream()
                .map(e -> e.get(1))
                .max(Integer::compare)
                .get() + 1;

//        System.out.println("line length: " + lines.get(0).length());
//        System.out.println("minx: " + minX + " maxx: " + maxX);
//        System.out.println("miny: " + minY + " maxy: " + maxY);
        HashMap<List<Integer>, Character> newGrid = new HashMap<>();
        int[][] steps = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {0, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

//        for (List<Integer> point : grid.keySet())
        for (int y = minY; y <= maxY; y++)
        {
            for (int x = minX; x <= maxX; x++)
            {
//                System.out.println("point: " + x + ", " + y);
                StringBuilder binaryString = new StringBuilder();
                List<Integer> position = new ArrayList<>(List.of(x, y));
                for (int[] step : steps)
                {
                    position.set(0, x + step[0]);
                    position.set(1, y + step[1]);

                    binaryString.append(grid.getOrDefault(position, outside));
                }
//                System.out.println("binarystring: " + binaryString);
                char value = enhancement[Integer.parseInt(binaryString.toString(), 2)];
                newGrid.put(List.of(x, y), value);
//                break;
            }
        }

//        System.out.println(newGrid);
        return newGrid;
    }

    private int getLitPoints()
    {
        int sum = grid.values().stream()
                .map(Character::getNumericValue)
                .mapToInt(Integer::intValue).sum();

        return sum;
    }

    public static HashMap<List<Integer>, Character> populateGrid(List<String> lines)
    {
        HashMap<List<Integer>, Character> grid = new HashMap<>();
        for (int y = 0; y < lines.size(); y++)
        {
            String[] line = lines.get(y).split("");
            for (int x = 0; x < line.length; x++)
            {
                if (Objects.equals(line[x], "."))
                {
                    grid.put(List.of(x, y), '0');
                }
                else
                {
                    grid.put(List.of(x, y), '1');
                }
            }
        }
        return grid;
    }

    public void printGrid()
    {
        int minX = grid.keySet().stream()
                .map(e -> e.get(0))
                .min(Integer::compare)
                .get() - 1;

        int maxX = grid.keySet().stream()
                .map(e -> e.get(0))
                .max(Integer::compare)
                .get() + 1;

        int minY = grid.keySet().stream()
                .map(e -> e.get(1))
                .min(Integer::compare)
                .get() - 1;

        int maxY = grid.keySet().stream()
                .map(e -> e.get(1))
                .max(Integer::compare)
                .get() + 1;

        for (int y = minY; y <= maxY; y++)
        {
            for (int x = minX; x <= maxX; x++)
            {
                List<Integer> point = List.of(x, y);
                if (grid.containsKey(point))
                {
                    System.out.print("'" + grid.get(point) + "'");
                }
                else
                {
                    System.out.print("'.'");
                }
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

    public HashMap<List<Integer>, Character> getGrid() {
        return grid;
    }
}
