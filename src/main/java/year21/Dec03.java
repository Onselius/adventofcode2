package year21;

import java.util.ArrayList;
import java.util.List;

public class Dec03 {

    private List<String> lines;

    public Dec03() {
    }

    protected long part1()
    {
        Integer[] numberOfones = getNumberOfOnes(lines);
        String epsilon = getMostCommon(lines, numberOfones);
        String gamma = getLeastCommon(lines, numberOfones);

        return Long.parseLong(epsilon, 2) * Long.parseLong(gamma, 2);
    }

    protected long part2()
    {
        String oxygen = getOxygen(lines);
        String scrubber = getScrubber(lines);

        return Long.parseLong(oxygen, 2) * Long.parseLong(scrubber, 2);
    }

    private String getMostCommon(List<String> lines, Integer[] numberOfones)
    {
        int lineLength = lines.get(0).length();
        String[] binary = new String[lineLength];

        for (int i = 0; i < lineLength; i++)
        {
            if (numberOfones[i] >= (float) lines.size() / 2)
            {
                binary[i] = "1";
            }
            else
            {
                binary[i] = "0";
            }
        }

        return String.join("", binary);
    }

    private String getLeastCommon(List<String> lines, Integer[] numberOfones)
    {
        int lineLength = lines.get(0).length();
        String[] binary = new String[lineLength];

        for (int i = 0; i < lineLength; i++)
        {
            if (numberOfones[i] < (float) lines.size() / 2)
            {
                binary[i] = "1";
            }
            else
            {
                binary[i] = "0";
            }
        }

        return String.join("", binary);
    }

    private Integer[] getNumberOfOnes(List<String> lines)
    {
        int lineLength = lines.get(0).length();
        Integer[] numberOfOnes = new Integer[lineLength];
        for (int i = 0; i < lineLength; i++)
        {
            int count = 0;
            for (String line : lines)
            {
                count += Integer.parseInt(String.valueOf(line.charAt(i)));
            }

            numberOfOnes[i] = count;
        }

        return numberOfOnes;
    }

    private String getOxygen(List<String> lines)
    {
        int lineLength = lines.get(0).length();
        List<String> currentLines = lines;
        List<String> nextLines;
        for (int i = 0; i < lineLength; i++)
        {
            Integer[] numberOfOnes = getNumberOfOnes(currentLines);
            String mostCommon = getMostCommon(currentLines, numberOfOnes);
            nextLines = new ArrayList<>();

            for (String line : currentLines)
            {
                if (line.charAt(i) == mostCommon.charAt(i))
                {
                    nextLines.add(line);
                }
            }
            currentLines = nextLines;
            if (currentLines.size() == 1)
            {
                break;
            }
        }

        return currentLines.get(0);
    }

    private String getScrubber(List<String> lines)
    {
        int lineLength = lines.get(0).length();
        List<String> currentLines = lines;
        List<String> nextLines;
        for (int i = 0; i < lineLength; i++)
        {
            Integer[] numberOfOnes = getNumberOfOnes(currentLines);
            String leastCommon = getLeastCommon(currentLines, numberOfOnes);
            nextLines = new ArrayList<>();

            for (String line : currentLines)
            {
                if (line.charAt(i) == leastCommon.charAt(i))
                {
                    nextLines.add(line);
                }
            }
            currentLines = nextLines;
            if (currentLines.size() == 1)
            {
                break;
            }
        }

        return currentLines.get(0);
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

}