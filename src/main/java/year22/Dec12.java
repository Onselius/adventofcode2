package year22;

import util.StopWatch;

import java.util.*;

public class Dec12 {
    private List<String> lines;
    private HashMap<List<Integer>, Integer> steps;
    private Queue<List<Integer>> queue;

    public Dec12() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        List<Integer> point = getPoint('S');
        List<Integer> finish = getPoint('E');
        queue = new LinkedList<>();
        steps = new HashMap<>();
        steps.put(point, 0);
        for (List<Integer> neighbour: getSurroundingPoints(point))
        {
            if (getMapValue(neighbour) - 1 <= 'a')
            {
                steps.put(neighbour, 1);
                queue.add(neighbour);
            }
        }
        while (queue.size() > 0)
        {
            point = queue.poll();
            int step = steps.get(point);
            char pointValue = getMapValue(point);
            List<List<Integer>> surroundingPoints = getSurroundingPoints(point);
            for (List<Integer> neighbour: surroundingPoints)
            {
                if (getMapValue(neighbour) - 1 <= pointValue &&
                    getMapValue(neighbour) != 'E' &&
                    steps.getOrDefault(neighbour, 10000) > step + 1)
                {
                    queue.add(neighbour);
                    steps.put(neighbour, step + 1);
                }
            }
        }

        printMap();

        stopWatch.stopTime();
        return steps.get(finish);
    }

    private List<Integer> getPoint(char value)
    {
        for (int y = 0; y < lines.size(); y++)
        {
            for (int x = 0; x < lines.get(0).length(); x++)
            {
                char c = lines.get(y).charAt(x);
                if (c == value)
                {
                    return List.of(y, x);
                }
            }
        }
        return List.of(0,0);
    }

    private char getMapValue(List<Integer> point)
    {
        char c = lines.get(point.get(0)).charAt(point.get(1));
        if (c == 'S')
        {
            return 'a';
        }
        else if (c == 'E')
        {
            return 'z';
        }
        return c;
    }

    private List<List<Integer>> getSurroundingPoints(List<Integer> point)
    {
        List<List<Integer>> points = new ArrayList<>();
        int y = point.get(0);
        int x = point.get(1);
        if (y - 1 >= 0)
        {
            points.add(List.of(y - 1, x));
        }
        if (y + 1 < lines.size())
        {
            points.add(List.of(y + 1, x));
        }
        if (x - 1 >= 0)
        {
            points.add(List.of(y, x - 1));
        }
        if (x + 1 < lines.get(0).length())
        {
            points.add(List.of(y, x + 1));
        }

        return points;
    }

    protected int part2()
    {
        StopWatch stopWatch = new StopWatch();
        List<Integer> point = getPoint('E');
        List<Integer> finish = null;
        queue = new LinkedList<>();
        steps = new HashMap<>();
        steps.put(point, 0);
        for (List<Integer> neighbour: getSurroundingPoints(point))
        {
            if (getMapValue(neighbour) + 1 >= getMapValue(point))
            {
                steps.put(neighbour, 1);
                queue.add(neighbour);
            }
        }
        while (queue.size() > 0)
        {
            point = queue.poll();
            int step = steps.get(point);
            char pointValue = getMapValue(point);
            List<List<Integer>> surroundingPoints = getSurroundingPoints(point);
            for (List<Integer> neighbour: surroundingPoints)
            {
                if (getMapValue(neighbour) + 1 >= pointValue &&
                        steps.getOrDefault(neighbour, 10000) > step + 1)
                {
                    queue.add(neighbour);
                    steps.put(neighbour, step + 1);
                    if (getMapValue(neighbour) == 'a')
                    {
                        finish = neighbour;
                        queue.clear();
                        break;
                    }
                }
            }
        }

        stopWatch.stopTime();
        return steps.get(finish);
    }

    private void printMap()
    {
        for (int y = 0; y < lines.size(); y++)
        {
            int size = lines.get(y).length();
            for (int x = 0; x < size; x++)
            {
                System.out.print(steps.getOrDefault(List.of(y, x), 0) + " ");
//                char c = steps.containsKey(List.of(y, x)) ? '#' : '.';
//                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
