package year21;

import util.ReadFile;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dec21 {

    private List<String> lines;
    private HashMap<String, List<Long>> memo;
    private long[] wins;
    private int endpoints;
    private HashMap<Integer, Integer> diceRolls;
    private final int POS0 = 0;
    private final int POS1 = 1;
    private final int SCORE0 = 2;
    private final int SCORE1 = 3;
    private final int TURN = 4;

    public Dec21() {
    }

    protected long part1(long endpoints)
    {
        int rolled = 0;
        long[] points = new long[2];
        int[] positions = new int[2];

        positions[0] = Integer.parseInt(lines.get(0).substring(lines.get(0).length() - 1)) - 1;
        positions[1] = Integer.parseInt(lines.get(1).substring(lines.get(1).length() - 1)) - 1;
        System.out.println(Arrays.toString(positions));
        System.out.println(Arrays.toString(points));

        int turn = 0;
        while (true)
        {
            positions[turn] += ++rolled;
            positions[turn] += ++rolled;
            positions[turn] += ++rolled;
            positions[turn] = positions[turn] % 10;
            points[turn] += positions[turn] + 1;
//            System.out.println("position: " + positions[turn]);
//            System.out.println("rolled: " + rolled);
//            System.out.println("points: " + points[turn]);
            if (points[turn] >= endpoints)
            {
                break;
            }
            turn = (turn + 1) % 2;
        }
        System.out.println(Arrays.toString(positions));
        System.out.println(Arrays.toString(points));
        System.out.println(rolled);
        long min = Arrays.stream(points).min().getAsLong();


        return min * rolled;
    }

    protected long part2(int endpoints)
    {
        this.endpoints = endpoints;
        this.wins = new long[2];
        this.memo = new HashMap<>();
        this.diceRolls = new HashMap<>(30);
        for (int i = 1; i <= 3; i++)
        {
            for (int j = 1; j <= 3; j++)
            {
                for (int k = 1; k <= 3; k++)
                {
                    int value = i + j + k;
                    this.diceRolls.put(value, this.diceRolls.getOrDefault(value, 0) + 1);
                }
            }
        }

        int position0 = Integer.parseInt(lines.get(0).substring(lines.get(0).length() - 1)) - 1;
        int position1 = Integer.parseInt(lines.get(1).substring(lines.get(1).length() - 1)) - 1;

        int[] values = new int[5];
        values[POS0] = position0;
        values[POS1] = position1;
        values[SCORE0] = 0;
        values[SCORE1] = 0;
        values[TURN] = 0;

        this.wins = rollDice(values);

        System.out.println(Arrays.toString(wins));
        return Arrays.stream(wins).max().getAsLong();
    }

    private long[] rollDice(int[] values)
    {
        long[] wins = new long[2];
        if (values[SCORE0] >= this.endpoints)
        {
            wins[0]++;
            return wins;
        }
        if (values[SCORE1] >= this.endpoints)
        {
            wins[1]++;
            return wins;
        }
        int next = (values[TURN] + 1) % 2;
        int turn = values[TURN];
        for (int roll : this.diceRolls.keySet())
        {
            int[] newValues = new int[5];
            if (turn == 0)
            {
                newValues[POS0] = (values[POS0] + roll) % 10;
                newValues[POS1] = values[POS1];
                newValues[SCORE0] = values[SCORE0] + newValues[POS0] + 1;
                newValues[SCORE1] = values[SCORE1];
            }
            else
            {
                newValues[POS0] = values[POS0];
                newValues[POS1] = (values[POS1] + roll) % 10;
                newValues[SCORE0] = values[SCORE0];
                newValues[SCORE1] = values[SCORE1] + newValues[POS1] + 1;
            }
            newValues[TURN] = next;
            String key = getKey(newValues);
            if (memo.containsKey(key))
            {
                List<Long> result = memo.get(key);
                wins[0] += result.get(0) * this.diceRolls.get(roll);
                wins[1] += result.get(1) * this.diceRolls.get(roll);
                continue;
            }
            long[] result = rollDice(newValues);
            wins[0] += result[0] * this.diceRolls.get(roll);
            wins[1] += result[1] * this.diceRolls.get(roll);
        }
        String key = getKey(values);
        this.memo.put(key, new ArrayList<>(List.of(wins[0], wins[1])));
        return wins;
    }

    private String getKey(int[] values)
    {
        return values[0] + ","
                + values[1] + ","
                + values[2] + ","
                + values[3] + ","
                + values[4];
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

    public HashMap<String, List<Long>> getMemo() {
        return memo;
    }
}
