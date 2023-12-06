package year23;

import util.StopWatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Dec04 {
    private List<String> lines;

    public Dec04() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        int sum = 0;

        for (String line: lines)
        {
            line = line.replaceAll("Card\\s+\\d+:\\s+", "");
            String[] card = line.split(" \\| ");
            Set<String> winnning = Arrays.stream(card[0].split("\\s+")).collect(Collectors.toSet());
            Set<String> numbers = Arrays.stream(card[1].split("\\s+")).collect(Collectors.toSet());
            numbers.retainAll(winnning);

            int correct = numbers.size() - 1;

            if(correct >= 0)
            {
                sum += (int) Math.pow(2, correct);
            }
        }

        stopWatch.stopTime();
        return sum;
    }

    protected int part2()
    {
        StopWatch stopWatch = new StopWatch();
        int sum = 0;
        Map<Integer, Integer> cards = new HashMap<>();

        for (int i = 0; i < lines.size(); i++)
        {
            int times = cards.getOrDefault(i, 1);
            String line = lines.get(i).replaceAll("Card\\s+\\d+:\\s+", "");
            String[] card = line.split(" \\| ");
            Set<String> winnning = Arrays.stream(card[0].split("\\s+")).collect(Collectors.toSet());
            Set<String> numbers = Arrays.stream(card[1].split("\\s+")).collect(Collectors.toSet());
            numbers.retainAll(winnning);

            int correct = numbers.size();

            for (int j = 1; j <= correct; j++)
            {
                cards.put(i + j, cards.getOrDefault(i + j, 1) + times);
            }
            sum += times;
        }

        stopWatch.stopTime();
        return sum;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
