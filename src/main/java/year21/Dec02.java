package year21;

import java.util.List;

public class Dec02 {

    public List<String> lines;

    public int part1()
    {
        int x = 0;
        int y = 0;
        String[] splitted;
        String command;
        int value;
        for (String line : lines)
        {
            splitted = line.split(" ");
            command = splitted[0];
            value = Integer.parseInt(splitted[1]);

            switch (command)
            {
                case "forward":
                    x += value;
                    break;
                case "up":
                    y -= value;
                    break;
                case "down":
                    y += value;
                    break;
            }
        }

        return x * y;
    }

    public int part2()
    {
        int x = 0;
        int y = 0;
        int aim = 0;
        String[] splitted;
        String command;
        int value;
        for (String line : lines)
        {
            splitted = line.split(" ");
            command = splitted[0];
            value = Integer.parseInt(splitted[1]);

            switch (command)
            {
                case "forward":
                    x += value;
                    y += aim * value;
                    break;
                case "up":
                    aim -= value;
                    break;
                case "down":
                    aim += value;
                    break;
            }
        }
        return x * y;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

}
