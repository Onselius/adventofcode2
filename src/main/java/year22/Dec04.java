package year22;

import java.util.Arrays;
import java.util.List;

public class Dec04 {
    private List<String> lines;

    public Dec04() {
    }

    protected int part1()
    {
        int count = 0;
        for (String line: lines)
        {
            String[] split = line.split(",");
            int[] a = Arrays.stream(split[0].split("-")).mapToInt(Integer::valueOf).toArray();
            int[] b = Arrays.stream(split[1].split("-")).mapToInt(Integer::valueOf).toArray();

            if (a[0] <= b[0] && a[1] >= b[1])
            {
                count++;
            }
            else if (b[0] <= a[0] && b[1] >= a[1])
            {
                count++;
            }
        }
        return count;
    }

    protected int part2()
    {
        int count = 0;
        for (String line: lines)
        {
            String[] split = line.split(",");
            int[] a = Arrays.stream(split[0].split("-")).mapToInt(Integer::valueOf).toArray();
            int[] b = Arrays.stream(split[1].split("-")).mapToInt(Integer::valueOf).toArray();

            System.out.println(line);
            if (a[0] <= b[0] && a[1] >= b[0])
            {
                count++;
            }
            else if (a[0] <= b[1] && a[1] >= b[1])
            {
                count++;
            }
            else if (a[0] >= b[0] && a[1] <= b[1])
            {
                count++;
            }
            System.out.println(count);
        }
        return count;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
