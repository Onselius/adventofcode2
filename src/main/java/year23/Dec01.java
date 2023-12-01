package year23;

import util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dec01 {
    private List<String> lines;

    public Dec01() {
    }

    protected int part1()
    {
        StopWatch stopWatch = new StopWatch();
        int sum = 0;

        for (String line: lines)
        {
            char first = 200;
            char last = 0;
            for (char c: line.toCharArray())
            {
                if (c < 60)
                {
                    if (first == 200)
                    {
                        first = c;
                        last = c;
                    }
                    else
                    {
                        last = c;
                    }
                }
            }
            sum += Integer.parseInt(Character.toString(first) + Character.toString(last));
        }

        stopWatch.stopTime();
        return sum;
    }

    protected int part2()
    {
        StopWatch stopWatch = new StopWatch();
        Pattern pattern = Pattern.compile("(\\d|zero|one|two|three|four|five|six|seven|eight|nine)");
//        Pattern pattern = Pattern.compile("(\\d)");
        Matcher matcher;
        int sum = 0;
        List<Integer> values = new ArrayList<>();

        for (String line: lines)
        {
            matcher = pattern.matcher(line);
            String first = "";
            String last = "";
            int i = 0;
            while(matcher.find(i))
            {
                String match = matcher.group();
                if (first.isEmpty())
                {
                    first = match;
                }
                last = match;
                if (match.length() == 1)
                {
                    i = matcher.end();
                }
                else
                {
                    i = matcher.end() - 1;
                }
            }
            int value = sumValues(first, last);
            sum += value;
            values.add(value);
        }


        stopWatch.stopTime();
        return sum;
    }

    private int sumValues(String first, String last)
    {
        String f = transformValue(first);
        String l = transformValue(last);

        int value =  Integer.parseInt(f + l);
        return value;
    }

    private String transformValue(String value)
    {
        switch (value)
        {
            case "0":
            case "zero":
                return "0";
            case "1":
            case "one":
                return "1";
            case "2":
            case "two":
                return "2";
            case "3":
            case "three":
                return "3";
            case "4":
            case "four":
                return "4";
            case "5":
            case "five":
                return "5";
            case "6":
            case "six":
                return "6";
            case "7":
            case "seven":
                return "7";
            case "8":
            case "eight":
                return "8";
            case "9":
            case "nine":
                return "9";
            default:
                return "";
        }
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }
}
