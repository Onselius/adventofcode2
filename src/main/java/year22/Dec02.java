package year22;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dec02 {
    private List<String> lines;
    private Map<String, Integer> player1 = new HashMap<>();
    private Map<String, Integer> player2 = new HashMap<>();
    private final int win = 6;
    private final int draw = 3;

    public Dec02() {
        // rock = 1
        // paper = 2
        // scissors = 3

        player1.put("A", 1);
        player1.put("B", 2);
        player1.put("C", 3);

        player2.put("X", 1);
        player2.put("Y", 2);
        player2.put("Z", 3);
    }

    protected int part1()
    {
        int sum = 0;
        for (String line : lines)
        {
            String[] splitted = line.split(" ");

            sum += getResult1(player1.get(splitted[0]), player2.get(splitted[1]));
        }

        return sum;
    }

    protected int part2()
    {
        int sum = 0;
        for (String line : lines)
        {
            String[] splitted = line.split(" ");

            sum += getResult2(player1.get(splitted[0]), player2.get(splitted[1]));
        }

        return sum;
    }

    private int getResult2(Integer a, Integer b)
    {
        if (b == 2)
        {
            return draw + a;
        }
        else if (b == 1)
        {
            if (a == 3 || a == 2)
            {
                return a - 1;
            }
            else
            {
                return 3;
            }
        }
        else
        {
            if (a == 2 || a == 1)
            {
                return win + a + 1;
            }
            else
            {
                return win + 1;
            }
        }
    }

    private int getResult1(int a, int b)
    {
        if (a == b)
        {
            return draw + b;
        }
        else if ((b == 1 && a == 3) || (b == 2 && a == 1) || (b == 3 && a == 2))
        {
            return win + b;
        }
        else
        {
            return b;
        }
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
