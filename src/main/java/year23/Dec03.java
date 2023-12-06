package year23;

import util.StopWatch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dec03 {
    private List<String> lines;

    public Dec03() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        Map<List<Integer>, Integer> numbers = new HashMap<>();
        Map<List<Integer>, Character> symbols = new HashMap<>();
        int sum = 0;

        readInput(symbols, numbers);

        for (List<Integer> symbol: symbols.keySet())
        {
            List<Integer> point;
            Set<Integer> added = new HashSet<>();
            for (int i = symbol.get(1) - 1; i <= symbol.get(1) + 1; i++)
            {
                point = List.of(symbol.get(0) - 1, i);
                if (numbers.containsKey(point))
                {
                    added.add(numbers.get(point));
                }
            }
            for (int i = symbol.get(1) - 1; i <= symbol.get(1) + 1; i += 2)
            {
                point = List.of(symbol.get(0), i);
                if (numbers.containsKey(point))
                {
                    added.add(numbers.get(point));
                }
            }
            for (int i = symbol.get(1) - 1; i <= symbol.get(1) + 1; i++)
            {
                point = List.of(symbol.get(0) + 1, i);
                if (numbers.containsKey(point))
                {
                    added.add(numbers.get(point));
                }
            }
            sum += added.stream().mapToInt(Integer::intValue).sum();
        }


        stopWatch.stopTime();
        return sum;
    }

    private void readInput(Map<List<Integer>, Character> symbols, Map<List<Integer>, Integer> numbers) {
        for (int y = 0; y < lines.size(); y++)
        {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
            {
                char c = line.charAt(x);
                if (c == '.')
                {
                    continue;
                }
                else if (c < 48 || c > 57)
                {
                    symbols.put(List.of(y, x), c);
                }
                else
                {
                    StringBuilder number = new StringBuilder();
                    int start = x;
                    int end = 0;
                    int i = x;
                    while (i < line.length())
                    {
                        c = line.charAt(i);
                        if (c < 48 || c > 57)
                        {
                            break;
                        }
                        number.append(c);
                        end = i;
                        i++;
                    }
                    int value = Integer.parseInt(number.toString());
                    for (i = start; i <= end; i++)
                    {
                        numbers.put(List.of(y, i), value);
                    }
                    x = end;
                }
            }
        }
    }


    protected long part2()
    {
        StopWatch stopWatch = new StopWatch();
        Map<List<Integer>, Integer> numbers = new HashMap<>();
        Map<List<Integer>, Character> symbols = new HashMap<>();
        long sum = 0L;

        readInput(symbols, numbers);
        List<List<Integer>> gears = symbols.entrySet().stream()
                .filter(x -> x.getValue() == '*')
                .map(x -> x.getKey())
                .toList();

        for (List<Integer> gear: gears)
        {
            List<Integer> point;
            Set<Integer> added = new HashSet<>();
            for (int i = gear.get(1) - 1; i <= gear.get(1) + 1; i++)
            {
                point = List.of(gear.get(0) - 1, i);
                if (numbers.containsKey(point))
                {
                    added.add(numbers.get(point));
                }
            }
            for (int i = gear.get(1) - 1; i <= gear.get(1) + 1; i += 2)
            {
                point = List.of(gear.get(0), i);
                if (numbers.containsKey(point))
                {
                    added.add(numbers.get(point));
                }
            }
            for (int i = gear.get(1) - 1; i <= gear.get(1) + 1; i++)
            {
                point = List.of(gear.get(0) + 1, i);
                if (numbers.containsKey(point))
                {
                    added.add(numbers.get(point));
                }
            }

            if (added.size() == 2)
            {
                sum += added.stream().mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);
            }
        }

        stopWatch.stopTime();
        return sum;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
