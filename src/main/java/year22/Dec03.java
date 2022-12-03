package year22;

import java.util.ArrayList;
import java.util.List;

public class Dec03 {
    private List<String> lines;
    private String points = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Dec03() {
    }

    protected int part1()
    {
        List<Character> items = new ArrayList<>();
        for (String line: lines)
        {
            int middle = line.length()/2;
            String second = line.substring(middle);
            for (int i = 0; i < middle; i++)
            {
                char c = line.charAt(i);
                if (second.indexOf(c) >= 0)
                {
                    items.add(c);
                    break;
                }
            }
        }
        int sum = 0;
        for (Character c : items)
        {
            sum += points.indexOf(c) + 1;
        }

        return sum;
    }

    protected int part2()
    {
        List<Character> items = new ArrayList<>();
        int length = lines.size();
        int sum = 0;
        for (int i = 0; i < length; i = i+3)
        {
            char common = 0;
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++)
            {
                char c = line.charAt(j);
                if (lines.get(i+1).indexOf(c) >= 0)
                {
                    if (lines.get(i+2).indexOf(c) >= 0)
                    {
                        common = c;
                        break;
                    }
                }
            }
            sum += points.indexOf(common) + 1;
        }

        return sum;

    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
