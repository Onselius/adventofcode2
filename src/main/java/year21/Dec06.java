package year21;

import util.ReadFile;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Dec06 {

    private List<String> lines;

    public Dec06() {
    }

    protected long part1(int days)
    {
        List<Integer> rawInput = Arrays.stream(lines.get(0).split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        HashMap<Integer, Long> fishes = new HashMap<>();
        for (int i = 0; i < 9; i++)
        {
            fishes.put(i, 0L);
        }
        for (Integer input : rawInput)
        {
            fishes.put(input, fishes.get(input) + 1);
        }
        for (int day = 0; day < days; day++)
        {
            long newFishes = fishes.get(0);
            for (int i = 0; i < 8; i++)
            {
                fishes.put(i, fishes.get(i + 1));
            }
            fishes.put(8, newFishes);
            fishes.put(6, fishes.get(6) + newFishes);
        }

        return fishes.values().stream().mapToLong(Long::valueOf).sum();
    }

    protected long part2(int days)
    {
        return part1(days);
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

}
