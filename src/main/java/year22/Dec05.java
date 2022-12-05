package year22;

import java.util.*;

public class Dec05 {
    private List<String> lines;

    private ArrayList<Stack<Character>> stacks = new ArrayList<>();

    public Dec05() {
    }

    protected String part1()
    {
        int instuction_start = 0;
        for (String line: lines)
        {
            instuction_start++;
            if (line.charAt(1) == '1')
            {
                instuction_start++;
                break;
            }
            int index = 0;
            for (int i = 1; i < line.length(); i += 4)
            {
                if (stacks.size() <= index)
                {
                    stacks.add(new Stack<>());
                }
                if (line.charAt(i) != ' ')
                {
                    stacks.get(index).add(0, line.charAt(i));
                }
                index++;
            }
        }
        System.out.println(stacks);

        for (int i = instuction_start; i < lines.size(); i++)
        {
            String line = lines.get(i);
            String[] split = line.split(" ");
            int amount = Integer.parseInt(split[1]);
            int start = Integer.parseInt(split[3])-1;
            int end = Integer.parseInt(split[5])-1;

            for (int j = 0; j < amount; j++)
            {
                char c = stacks.get(start).pop();
                stacks.get(end).push(c);
            }
            System.out.println(stacks);
            System.out.println();
        }

        StringBuilder builder = new StringBuilder();
        for (Stack<Character> stack: stacks)
        {
            if (stack.isEmpty())
            {
                continue;
            }
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    protected String part2()
    {
        int instuction_start = 0;
        for (String line: lines)
        {
            instuction_start++;
            if (line.charAt(1) == '1')
            {
                instuction_start++;
                break;
            }
            int index = 0;
            for (int i = 1; i < line.length(); i += 4)
            {
                if (stacks.size() <= index)
                {
                    stacks.add(new Stack<>());
                }
                if (line.charAt(i) != ' ')
                {
                    stacks.get(index).add(0, line.charAt(i));
                }
                index++;
            }
        }
        System.out.println(stacks);

        for (int i = instuction_start; i < lines.size(); i++)
        {
            String line = lines.get(i);
            String[] split = line.split(" ");
            int amount = Integer.parseInt(split[1]);
            int start = Integer.parseInt(split[3])-1;
            int end = Integer.parseInt(split[5])-1;

            int start_index = stacks.get(start).size();
            int end_index = stacks.get(end).size();
            for (int j = 0; j < amount; j++)
            {
                char c = stacks.get(start).pop();
                stacks.get(end).add(end_index, c);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Stack<Character> stack: stacks)
        {
            if (stack.isEmpty())
            {
                continue;
            }
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
