package year21;

import util.ReadFile;

import java.net.URL;
import java.util.*;

public class Dec10 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;
    private List<Character> starting = new ArrayList<>(Arrays.asList('(', '[', '<', '{'));
    private List<Character> ending = new ArrayList<>(Arrays.asList(')', ']', '>', '}'));

    public Dec10() {
    }

    protected long part1()
    {
        HashMap<Character, Integer> points = new HashMap<>();
        points.put(')', 3);
        points.put(']', 57);
        points.put('}', 1197);
        points.put('>', 25137);

        Stack<Character> stack = new Stack();
        long syntaxPoints = 0;
        for (String line : lines)
        {
            for (char c : line.toCharArray())
            {
                if (starting.contains(c))
                {
                    stack.add(c);
                    continue;
                }
                if (convertToEnd(stack.pop()) != c)
                {
                    syntaxPoints += points.get(c);
                    break;
                }
            }
        }

        return syntaxPoints;
    }

    private Character convertToEnd(char c)
    {
        if (c == '(')
        {
            return ')';
        }
        else if ( c == '[')
        {
            return ']';
        }
        else if ( c == '<')
        {
            return '>';
        }
        else
        {
            return '}';
        }
    }


    protected long part2()
    {

        Stack<Character> stack = new Stack<>();
        List<Character> padding = new ArrayList<>();
        List<Long> scores = new ArrayList<>();
        for (String line : lines)
        {
            padding.clear();
            stack.clear();
            for (char c : line.toCharArray())
            {
                if (starting.contains(c))
                {
                    stack.add(c);
                    continue;
                }
                if (convertToEnd(stack.pop()) != c)
                {
                    stack.clear();
                    break;
                }
            }
            if (stack.isEmpty())
            {
                continue;
            }
            while (!stack.isEmpty())
            {
                padding.add(convertToEnd(stack.pop()));
            }
            scores.add(calculateScore(padding));
        }

        Collections.sort(scores);

        return scores.get((scores.size() / 2));
    }

    private long calculateScore(List<Character> padding)
    {
        HashMap<Character, Integer> points = new HashMap<>();
        points.put(')', 1);
        points.put(']', 2);
        points.put('}', 3);
        points.put('>', 4);

        long score = 0;
        for (char c : padding)
        {
            score *= 5;
            score += points.get(c);
        }

        return score;
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
