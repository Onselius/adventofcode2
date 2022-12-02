package year21;

import util.ReadFile;

import java.net.URL;
import java.util.*;

public class Dec17 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;

    public Dec17() {
        this.grid = new HashMap<>();
    }

    protected long part1()
    {
        HashMap<String, Integer> targetArea = getTargetArea();
        for (int y = 0; y < 500; y++)
        {
            for (int x = 0; x < 500; x++)
            {
                step(targetArea, x, y);
            }
        }

        int max = this.grid.values().stream().max(Integer::compareTo).get();

        return max;
    }

    protected long part2()
    {
        HashMap<String, Integer> targetArea = getTargetArea();
        for (int y = -120; y < 500; y++)
        {
            for (int x = 0; x < 500; x++)
            {
                step(targetArea, x, y);
            }
        }

        return this.grid.keySet().size();
    }

    private void step(HashMap<String, Integer> targetArea, int x, int y)
    {
        int ymax = y;
        int[] position = new int[] {0, 0};
        List<Integer> startPosition = List.of(x, y);
        while (position[0] < targetArea.get("xmax") && position[1] > targetArea.get("ymin"))
        {
            position[0] = position[0] + x;
            position[1] = position[1] + y;
            if (x > 0) x--;
            if (x < 0) x++;
            y--;
            //System.out.println(Arrays.toString(position));
            if (position[0] >= targetArea.get("xmin") &&
                    position[0] <= targetArea.get("xmax") &&
                    position[1] <= targetArea.get("ymax") &&
                    position[1] >= targetArea.get("ymin"))
            {
            //    System.out.println("inside targetarea");
                this.grid.put(startPosition, ymax);
                break;
            }
            if (position[1] > ymax)
            {
                ymax = position[1];
            }
        }
    }

    private HashMap<String, Integer> getTargetArea()
    {
        String coords = lines.get(0).replace("target area: ", "");
        String[] splitted = coords.split(", ");
        splitted[0] = splitted[0].replace("x=", "");
        splitted[1] = splitted[1].replace("y=", "");
        String[] xValue = splitted[0].split("\\.\\.");
        String[] yValue = splitted[1].split("\\.\\.");
        HashMap<String, Integer> targetArea = new HashMap<>();

        targetArea.put("xmin", Integer.valueOf(xValue[0]));
        targetArea.put("xmax", Integer.valueOf(xValue[1]));
        targetArea.put("ymin", Integer.valueOf(yValue[0]));
        targetArea.put("ymax", Integer.valueOf(yValue[1]));

        return targetArea;
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
