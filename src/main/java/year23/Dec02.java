package year23;

import util.StopWatch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dec02 {
    private List<String> lines;

    public Dec02() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        int id = 1;
        Map<String, Integer> cubes;
        int answer = 0;

        for (String line: lines)
        {
            line = line.replaceAll("Game \\d+: ", "");
            String[] sets = line.split(";");
            boolean possible = true;
            for (String set: sets)
            {
                cubes = new HashMap<>();
                String[] partCubes = set.split(",");
                for (String part: partCubes)
                {
                    String[] cube = part.trim().split(" ");
                    cubes.put(cube[1], cubes.getOrDefault(cube[1], 0) + Integer.parseInt(cube[0]));
                    if(!possibleGame(cubes))
                    {
                        possible = false;
                        break;
                    }
                }
            }
            if (possible)
            {
                answer += id;
            }

            id++;
        }


        stopWatch.stopTime();
        return answer;
    }

    private boolean possibleGame(Map<String, Integer> cubes)
    {
        return cubes.getOrDefault("blue", 0) <= 14 && cubes.getOrDefault("red", 0) <= 12 && cubes.getOrDefault("green", 0) <= 13;
    }

    protected int part2()
    {
        StopWatch stopWatch = new StopWatch();
        Map<String, Integer> cubes;
        int answer = 0;

        for (String line: lines)
        {
            line = line.replaceAll("Game \\d+: ", "");
            String[] sets = line.split(";");
            cubes = new HashMap<>();
            for (String set: sets)
            {
                String[] partCubes = set.split(",");
                for (String part: partCubes)
                {
                    String[] cube = part.trim().split(" ");
                    int number = Integer.parseInt(cube[0]);
                    if (cubes.getOrDefault(cube[1], 0) < number)
                    {
                        cubes.put(cube[1], number);
                    }
                }
            }
            answer += cubes.values().stream().reduce(1, (a, b) -> a * b);
        }

        stopWatch.stopTime();
        return answer;
    }


    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
