package year21;

import java.util.List;

public class Dec01 {

    private List<Integer> lines;

    public Dec01() {
    }

    protected int part1()
    {
        int previous = lines.get(0);
        int numberOfIncreases = 0;

        for (Integer i: lines)
        {
            if (i > previous)
            {
                numberOfIncreases++;
            }
            previous = i;
        }

        return numberOfIncreases;
    }

    protected int part2()
    {
        int previous = getThreePartSum(0);
        int next;
        int numberOfIncreases = 0;

        for (int i = 1; i < lines.size() - 2; i++)
        {
            next = getThreePartSum(i);
            if (next > previous)
            {
                numberOfIncreases++;
            }

            previous = next;
        }

        return numberOfIncreases;
    }

    private int getThreePartSum(int index)
    {
        int sum = lines.get(index);
        sum += lines.get(index + 1);
        sum += lines.get(index + 2);

        return sum;
    }

    public List<Integer> getLines() {
        return lines;
    }

    public void setLines(List<Integer> lines) {
        this.lines = lines;
    }

}