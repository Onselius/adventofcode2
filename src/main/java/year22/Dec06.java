package year22;

import java.util.List;

public class Dec06 {
    private List<String> lines;

    public Dec06() {
    }

    protected int part1()
    {
        String input = lines.get(0);
        int i = 4;
        for(; i < input.length(); i++)
        {
            String subLine = input.substring(i-4, i);
            boolean foundMatch = false;
            for (int j = 0; j < 4; j++)
            {
                char c = subLine.charAt(j);
                if (subLine.lastIndexOf(c) != j)
                {
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch)
            {
                System.out.println("subline = " + subLine);
                break;
            }
        }

        return i;
    }

    protected int part2()
    {
        String input = lines.get(0);
        int i = 14;
        for(; i < input.length(); i++)
        {
            String subLine = input.substring(i-14, i);
            boolean foundMatch = false;
            for (int j = 0; j < 14; j++)
            {
                char c = subLine.charAt(j);
                if (subLine.lastIndexOf(c) != j)
                {
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch)
            {
                System.out.println("subline = " + subLine);
                break;
            }
        }

        return i;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
