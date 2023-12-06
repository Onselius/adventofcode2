package year23;

import util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalLong;
import java.util.Set;
import java.util.stream.Collectors;

public class Dec05 {
    private List<String> lines;

    public Dec05() {
    }

    protected long part1()
    {
        StopWatch stopWatch = new StopWatch();
        long[] seeds = Arrays.stream(lines.get(0).substring(7).split("\\s")).mapToLong(Long::parseLong).toArray();

        long[] in = seeds.clone();
        long[] out = in.clone();
        String line;
        int i = 3;

        while (i < lines.size())
        {
            line = lines.get(i);
            if (line.isBlank())
            {
                in = out.clone();
                i += 2;
                continue;
            }
            long[] mapping = Arrays.stream(line.split("\\s")).mapToLong(Long::parseLong).toArray();
            long destination = mapping[0];
            long source = mapping[1];
            long range = mapping[2] - 1;
            for (int j = 0; j < in.length; j++)
            {
                if (in[j] >= source && in[j] <= source + range)
                {
                    out[j] = (in[j] - source) + destination;
                }
            }
            i++;
        }

        int lowest = 0;
        for (i = 0; i < out.length; i++)
        {
            if (out[i] < out[lowest])
            {
                lowest = i;
            }
        }

        stopWatch.stopTime();
        return out[lowest];
    }

    protected long part2()
    {
        StopWatch stopWatch = new StopWatch();
        long[] input = Arrays.stream(lines.get(0).substring(7).split("\\s")).mapToLong(Long::parseLong).toArray();
        ArrayList<ArrayList<Long>> in = new ArrayList<>();
        for (int x = 0; x < input.length; x += 2)
        {
//            in.add((ArrayList<Long>) List.of(input[x], input[x+1]));
            in.add(new ArrayList<>(List.of(input[x], input[x+1])));
        }

        ArrayList<ArrayList<Long>> out = new ArrayList<>();
        String line;
        int i = 3;
        long rangeSum = in.stream().mapToLong(x -> x.get(1)).sum();

        while (i < lines.size())
        {
            line = lines.get(i);
            if (line.isBlank())
            {
                in = (ArrayList<ArrayList<Long>>) in.stream().filter(l -> l.get(0) > 0).collect(Collectors.toList());
                in.addAll(out);
                out.clear();
                i += 2;
                long newSum = in.stream().mapToLong(x -> x.get(1)).sum();
                if (newSum != rangeSum)
                {
                    System.out.println("something is off");
                }
                continue;
            }
            long[] mapping = Arrays.stream(line.split("\\s")).mapToLong(Long::parseLong).toArray();
            long destination = mapping[0];
            long source = mapping[1];
            long range = mapping[2] - 1;
            for (int j = 0; j < in.size(); j++)
            {
                List<Long> seed = in.get(j);
                long seedStart = seed.get(0);
                long seedRange = seed.get(1) - 1;
                long seedEnd = seedStart + seedRange;
                if (seedStart >= source && seedStart <= source + range)
                {
                    long diff = seedStart - source;
                    if (seedEnd <= source + range)
                    {
//                        out.add((ArrayList<Long>) List.of(destination + diff, seedRange + 1));
                        out.add(new ArrayList<>(List.of(destination + diff, seedRange + 1)));
                        seed.set(0, -1L);
                        seed.set(1, -1L);
                    }
                    else
                    {
//                        out.add((ArrayList<Long>) List.of(destination + diff, range + 1));
                        long diffRange = (source + range + 1) - seedStart;
                        out.add(new ArrayList<>(List.of(destination + diff, diffRange)));
//                        newIn.add(new ArrayList<>(List.of(source + range + 1, seedRange - diffRange + 1)));
//                        unchanged.add(List.of(source + range + 1, seedRange + 1));
                        seed.set(0, source + range + 1);
                        seed.set(1, seedRange - diffRange + 1);
                    }
                }
                else if (seedEnd >= source && seedEnd <= source + range)
                {
//                    out.add((ArrayList<Long>) List.of(destination, seedEnd - source));
                    out.add(new ArrayList<>(List.of(destination, seedEnd - source)));
//                    newIn.add(new ArrayList<>(List.of(seedStart, source - seedStart + 1)));
//                    unchanged.add(List.of(seedStart, source - seedStart));
                    seed.set(0, seedStart);
                    seed.set(1, source - seedStart + 1);
                }
                else if (seedStart <= source && seedEnd >= source + range)
                {
                    out.add(new ArrayList<>(List.of(destination, range)));
                    seed.set(0, seedStart);
                    seed.set(1, seedStart - source);
                    in.add(new ArrayList<>(List.of(source + range + 1, seedEnd - source + range)));
                }
            }
            i++;
        }

        in = (ArrayList<ArrayList<Long>>) in.stream().filter(l -> l.get(0) > 0).collect(Collectors.toList());
        in.addAll(out);
        OptionalLong lowest = in.stream()
                .map(x -> x.get(0))
                .mapToLong(Long::longValue)
                .min();

        long low = Long.MAX_VALUE;
        for (List<Long> list: in)
        {
            if (list.get(0) < low)
            {
                low = list.get(0);
            }
        }

        stopWatch.stopTime();
        return lowest.getAsLong();
    }
    // 18458048
    // 1429791513
    // 24098313

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
