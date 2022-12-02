package year22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dec01 {
    private List<String> lines;

    public Dec01() {
    }

    protected int part1()
    {
        ArrayList<Integer> calories = getCalories();

        return calories.get(calories.size()-1);
    }

    protected ArrayList<Integer> getCalories()
    {
        ArrayList<Integer> calories = new ArrayList<>(lines.size());

        int sum = 0;
        for (String line: lines)
        {
            if (line.isEmpty())
            {
                calories.add(sum);
                sum = 0;
                continue;
            }
            int number = Integer.parseInt(line);
            sum += number;
        }
        calories.add(sum);

        Collections.sort(calories);
        return calories;
    }

    protected int part2()
    {
        ArrayList<Integer> calories = getCalories();

        int size = calories.size();
        int sum = calories.get(size-1) + calories.get(size-2) + calories.get(size-3);

        return sum;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
