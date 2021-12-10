package year21;

import util.ReadFile;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dec08 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;

    public Dec08() {
    }

    protected long part1()
    {
        List<String> splitted = lines.stream()
                .map(e -> e.split(" \\| ")[1])
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.toList());

        int count = 0;
        for (String s : splitted)
        {

            if (s.length() == 2 || s.length() == 3 || s.length() == 4 || s.length() == 7)
            {
                count++;
            }
        }

        return count;
    }

    protected long part2()
    {
        long sum = 0;
        for (String[] line : lines.stream().map(e -> e.split(" \\| ")).collect(Collectors.toList()))
        {
            sum += Long.parseLong
                    (
                        decodeLine(line[0].split(" "), line[1].split(" "))
                    );
        }

        return sum;
    }

    private String decodeLine(String[] numbers, String[] answer)
    {
        List<String> sorted = Arrays.stream(numbers)
                .map(String::toCharArray)
                .peek(Arrays::sort)
                .map(String::valueOf)
                .collect(Collectors.toList());
        HashMap<String, List<String>> values = new HashMap<>();
        while (values.size() < 10)
        {
            for (String s : sorted)
            {
                List<String> value = List.of(s.split(""));
                if (values.containsValue(value))
                {
                    continue;
                }
                switch (s.length())
                {
                    case 2:
                        values.put("1", value);
                        break;
                    case 3:
                        values.put("7", value);
                        break;
                    case 4:
                        values.put("4", value);
                        break;
                    case 7:
                        values.put("8", value);
                        break;
                    case 5:
                        if (values.containsKey("3") && values.containsKey("5"))
                        {
                            values.put("2", value);
                            break;
                        }
                        if (values.containsKey("1") && value.containsAll(values.get("1")))
                        {
                            values.put("3", value);
                        }
                        else if (values.containsKey("9") && values.get("9").containsAll(value))
                        {
                            values.put("5", value);
                        }
                        break;
                    case 6:
                        if (values.containsKey("6") && values.containsKey("9"))
                        {
                            values.put("0", value);
                            break;
                        }
                        if (values.containsKey("4"))
                        {
                            if (value.containsAll(values.get("4")))
                            {
                                values.put("9", value);
                                break;
                            }
                        }
                        if (values.containsKey("5"))
                        {
                            if (value.containsAll(values.get("5")))
                            {
                                values.put("6", value);
                            }
                        }
                        break;
                }
//                System.out.println(values);
            }
        }
        sorted = Arrays.stream(answer)
                .map(String::toCharArray)
                .peek(Arrays::sort)
                .map(String::valueOf)
                .collect(Collectors.toList());
        StringBuilder numberString = new StringBuilder();
        for (String chars : sorted)
        {
            for (Map.Entry<String, List<String>> entry : values.entrySet())
            {
                if (String.join("", entry.getValue()).equals(chars))
                {
                    numberString.append(entry.getKey());
                }
            }
        }
//        System.out.println("string: " + sorted + " numeric: " + numberString);
        return numberString.toString();
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

    public HashMap<List<Integer>, Integer> getGrid() {
        return grid;
    }
}
