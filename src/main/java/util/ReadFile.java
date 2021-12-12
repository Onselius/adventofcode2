package util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {

    public static List<String> getTextFromFile(String inputFile){
        List<String> lines = new ArrayList<>();
        try {
            File input = new File(inputFile);
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String line;

            while ((line = reader.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<Long> convertToLong(List<String> lines){
        return lines.stream().map(Long::parseLong).collect(Collectors.toList());
    }

    public static List<Integer> convertToInteger (List<String> lines){
        return lines.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static HashMap<List<Integer>, Integer> populateGrid(List<String> lines)
    {
        HashMap<List<Integer>, Integer> grid = new HashMap<>();
        for (int y = 0; y < lines.size(); y++)
        {
            String[] line = lines.get(y).split("");
            for (int x = 0; x < lines.get(0).length(); x++)
            {
                grid.put(List.of(y, x), Integer.parseInt(line[x]));
            }
        }
        return grid;
    }
}