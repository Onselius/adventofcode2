package year22;

import util.StopWatch;

import java.util.HashSet;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class Dec09 {
    private List<String> lines;
    private HashSet<List<Integer>> visited;
    private int[][] knots;

    public Dec09() {
    }

    protected int part1() throws InterruptedException
    {
        StopWatch stopWatch = new StopWatch();
        int visits = execute(2);
        stopWatch.stopTime();
        return visits;
    }

    private int execute(int size)
    {
        this.visited = new HashSet<>();
        knots = new int[size][2];
        for (int i = 0; i < size; i++)
        {
            knots[i][0] = 100;
            knots[i][1] = 100;
        }
        addToVisited();

        for (String line: lines)
        {
            String[] splitted = line.split(" ");
            int steps = Integer.parseInt(splitted[1]);
            char direction = splitted[0].charAt(0);
            for (int i = 0; i < steps; i++)
            {
                moveHead(direction);
                for (int j = 1; j < knots.length; j++)
                {
                    moveKnot(knots[j - 1], knots[j]);
                }
                addToVisited();
            }
        }
        printGrid();
        return visited.size();
    }

    private void moveKnot(int[] head,
                          int[] tail)
    {
        int axis = 0;
        if (abs(head[0] - tail[0]) >= 2)
        {
            axis += 1;
        }
        if (abs(head[1] - tail[1]) >= 2)
        {
            axis += 2;
        }
        if (axis == 0)
        {
            return;
        }

        switch (axis)
        {
            case 1:
                tail[0] = round((head[0] + tail[0]) / 2f);
                tail[1] = head[1];
                break;
            case 2:
                tail[1] = round((head[1] + tail[1]) / 2f);
                tail[0] = head[0];
                break;
            case 3:
                tail[1] = round((head[1] + tail[1]) / 2f);
                tail[0] = round((head[0] + tail[0]) / 2f);
                break;
        }
    }

    private void moveHead(char direction)
    {
        switch (direction)
        {
            case 'R':
                knots[0][0] += 1;
                break;
            case 'U':
                knots[0][1] -= 1;
                break;
            case 'L':
                knots[0][0] -= 1;
                break;
            case 'D':
                knots[0][1] += 1;
                break;
        }
    }

    private void addToVisited()
    {
        int[] knot = knots[knots.length - 1];
        visited.add(List.of(knot[0], knot[1]));
    }

    private void printGrid()
    {
        for (int y = 90; y < 110; y++)
        {
            for (int x = 90; x < 110; x++)
            {
                char c = '.';
                if (knots[0][0] == x && knots[0][1] == y)
                {
                    c = 'H';
                }
                else if (visited.contains(List.of(x, y)))
                {
                    c = '#';
                }
                else
                {
                    for (int i = 1; i < knots.length; i++)
                    {
                        if (knots[i][0] == x && knots[i][1] == y)
                        {
                            c = (char) (i + 48);
                        }
                    }
                }
                System.out.print(c);
            }
            System.out.println();
        }
    }

    protected int part2()
    {
        StopWatch stopWatch = new StopWatch();
        int visits = execute(10);
        stopWatch.stopTime();
        return visits;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
