package year22;

import util.StopWatch;

import java.util.List;

public class Dec10 {
    private List<String> lines;

    public Dec10() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        int breakpoint = 20;
        int cycle = 1;
        int strength = 0;
        int x = 1;
        for (String line: lines)
        {
            String[] splitted = line.split(" ");
            String op = splitted[0];
            int value;
            int cycles;
            if (op.equals("noop"))
            {
                cycles = 1;
                value = 0;
            }
            else
            {
                cycles = 2;
                value = Integer.parseInt(splitted[1]);
            }
            for (int i = 0; i < cycles; i++)
            {
                if (cycle == breakpoint && cycle <= 220)
                {
                    breakpoint += 40;
                    strength += cycle * x;
                }
                cycle++;
            }
            x += value;
        }


        stopWatch.stopTime();
        return strength;
    }

    protected int part2()
    {
        StopWatch stopWatch = new StopWatch();

        int cycle = 1;
        int x = 1;
        int y = 0;
        int xpos = 0;
        int[][] screen = new int[6][40];
        for (String line: lines)
        {
            String[] splitted = line.split(" ");
            String op = splitted[0];
            int value;
            int cycles;
            if (op.equals("noop"))
            {
                cycles = 1;
                value = 0;
            }
            else
            {
                cycles = 2;
                value = Integer.parseInt(splitted[1]);
            }
            for (int i = 0; i < cycles; i++)
            {
                if (xpos == x - 1 || xpos == x || xpos == x + 1)
                {
                    screen[y][xpos] = '#';
                }
                else
                {
                    screen[y][xpos] = '.';
                }
                y = cycle / 40;
                xpos = cycle % 40;
                cycle++;

            }
            x += value;
        }

        printScreen(screen);

        stopWatch.stopTime();
        return 1;
    }

    private void printScreen(int[][] screen)
    {
        for (int y = 0; y < screen.length; y++)
        {
            for (int x = 0; x < screen[y].length; x++)
            {
                System.out.print((char) screen[y][x]);
            }
            System.out.println();
        }
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
