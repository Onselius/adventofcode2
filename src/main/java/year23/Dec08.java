package year23;

import util.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dec08 {
    private List<String> lines;

    public Dec08() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        int[] direction = lines.get(0).chars()
                .map(i -> {if (i == 76)  return 0; else return 1;})
                .toArray();

        Map<String, List<String>> nodes = new HashMap<>();

        for (int i = 2; i < lines.size(); i++)
        {
            Pattern pattern = Pattern.compile("([A-Z]{3}).*([A-Z]{3}).*([A-Z]{3})");
            Matcher matcher = pattern.matcher(lines.get(i));
            if (matcher.find())
            {
                nodes.put(matcher.group(1), List.of(matcher.group(2), matcher.group(3)));
            }
        }

        List<String> activeNode = nodes.get("AAA");
        String newNode;
        int i = 0;
        int steps = 0;

        while (true)
        {
            newNode = activeNode.get(direction[i]);
            steps++;

            if (newNode.equals("ZZZ")) break;

            activeNode = nodes.get(newNode);
            i++;
            if (i == direction.length) i = 0;
        }

        stopWatch.stopTime();
        return steps;
    }

    protected long part2()
    {
        StopWatch stopWatch = new StopWatch();
        int[] direction = lines.get(0).chars()
                .map(i -> {if (i == 76)  return 0; else return 1;})
                .toArray();

        Map<String, List<String>> nodes = new HashMap<>();

        for (int i = 2; i < lines.size(); i++)
        {
            Pattern pattern = Pattern.compile("([A-Z0-9]{3}).*([A-Z0-9]{3}).*([A-Z0-9]{3})");
            Matcher matcher = pattern.matcher(lines.get(i));
            if (matcher.find())
            {
                nodes.put(matcher.group(1), List.of(matcher.group(2), matcher.group(3)));
            }
        }

        List<String> startPositions = nodes.keySet().stream().filter(k -> k.endsWith("A")).toList();

        List<String> activeNode = nodes.get("AAA");
        String newNode;
        int steps;
        long answer = 1;
        List<Integer> steppelistepp = new ArrayList<>();

        for (String start: startPositions)
        {
            activeNode = nodes.get(start);
            int i = 0;
            steps = 0;
            while (true)
            {
                newNode = activeNode.get(direction[i]);
                steps++;

                if (newNode.endsWith("Z")) break;

                activeNode = nodes.get(newNode);
                i++;
                if (i == direction.length) i = 0;
            }
            steppelistepp.add(steps);
            answer = leastCommonMultiple(steps, answer);
        }

        stopWatch.stopTime();
        return answer;
    }

    public static long leastCommonMultiple(long n1, long n2){
        long higher = Math.max(n1, n2);
        long lcm = higher;
        long lower = Math.min(n1, n2);
        while (lcm % lower != 0){
            lcm += higher;
        }
        return lcm;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
