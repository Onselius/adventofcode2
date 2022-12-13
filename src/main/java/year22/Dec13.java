package year22;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.StopWatch;

import java.util.List;

public class Dec13 {
    private List<String> lines;

    public Dec13() {
    }

    protected int part1() throws ParseException
    {
        StopWatch stopWatch = new StopWatch();
        JSONParser parser = new JSONParser();
        int index = 1;
        int sum = 0;
        for (int i = 0; i < lines.size(); i += 3)
        {

            JSONArray first = (JSONArray) parser.parse(lines.get(i));
            JSONArray second = (JSONArray) parser.parse(lines.get(i+1));
            System.out.println(index + " " + first + " " + second);

            int correct = this.compare(first, second);
            if(correct == 1) sum += index;
            if(correct == 0) System.out.println("returned 0");
//            System.out.println(correct);
//            System.out.println(sum);

            index++;
        }


        stopWatch.stopTime();
        return sum;
    }

    private int compare(JSONArray first,
                            JSONArray second)
    {
        int correct = 1;
        for (int i = 0; i < first.size(); i++)
        {
            Object left = first.get(i);
            Object right;
            try
            {
                right = second.get(i);
            } catch (IndexOutOfBoundsException e)
            {
                return -1;
            }
            if (left.getClass().equals(JSONArray.class) && right.getClass().equals(JSONArray.class))
            {
                correct = compare((JSONArray) left, (JSONArray) right);
            } else if (left.getClass().equals(JSONArray.class))
            {
                JSONArray newRight = new JSONArray();
                newRight.add(right);
                correct = compare((JSONArray) left, newRight);
            } else if (right.getClass().equals(JSONArray.class))
            {
                JSONArray newLeft = new JSONArray();
                newLeft.add(left);
                correct = compare(newLeft, (JSONArray) right);
            } else {
                if ((long) left > (long) right)
                {
                    return -1;
                } else if ((long) left < (long) right)
                {
                    return 1;
                }
                else
                {
                    correct = 0;
                    if (i == first.size()-1 && first.size() < second.size() ) correct = 1;
                }
            }
            if (correct != 0) return correct;
        }
        return correct;
    }

    protected int part2()
    {
        StopWatch stopWatch = new StopWatch();


        stopWatch.stopTime();
        return 1;
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
