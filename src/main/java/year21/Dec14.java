package year21;

import util.ReadFile;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class Dec14 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;
    private HashMap<List<String>, String> reactions;

    public Dec14() {
    }

    protected long part1(int steps)
    {
        List<String> template = List.of(lines.get(0).split(""));

        HashMap<List<String>, Long> values = getPairs(template);
        reactions = parseReactions();

        HashMap<String, Long> counts;
        for (int i = 0; i < steps; i++)
        {
            values = react(values);
        }
        counts = count(values);
        counts.put(template.get(0), counts.get(template.get(0)) + 1);

        long max = counts.values().stream().max(Long::compare).get();
        long min = counts.values().stream().min(Long::compare).get();

        long result = (max - min);

        return (result);

    }

    protected long part2(int steps)
    {
        return part1(steps);
    }

    private HashMap<List<String>, Long> getPairs(List<String> template)
    {
        HashMap<List<String>, Long> values = new HashMap<>();
        for (int i = 0; i < template.size() - 1; i++)
        {
            List<String> pair = List.of(template.get(i), template.get(i + 1));
            values.put(pair, values.getOrDefault(pair, 0L) + 1);
        }

        return values;
    }

    private HashMap<List<String>, Long> react(HashMap<List<String>, Long> values)
    {
        HashMap<List<String>, Long> newValues = new HashMap<>();
        for (List<String> list : values.keySet())
        {
            List<String> pair = List.of(list.get(0), reactions.get(list));
            newValues.put(pair, newValues.getOrDefault(pair, 0L) + values.get(list));
            pair = List.of(reactions.get(list), list.get(1));
            newValues.put(pair, newValues.getOrDefault(pair, 0L) + values.get(list));
        }

        return newValues;
    }

    private HashMap<String, Long> count(HashMap<List<String>, Long> values)
    {
        HashMap<String, Long> counts = new HashMap<>();

        for (List<String> list : values.keySet())
        {
            counts.put(list.get(1), counts.getOrDefault(list.get(1), 1L) + values.get(list));
        }
        return counts;
    }


    private HashMap<List<String>, String> parseReactions()
    {
        HashMap<List<String>, String> reactions = new HashMap<>();
        for (int i = 2; i < lines.size(); i++)
        {
            String[] splitted = lines.get(i).split(" -> ");
            reactions.put(List.of(splitted[0].split("")), splitted[1]);
        }
        return reactions;
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


/*
NN
NCN
NBCCN
NBBBCNCCN
NBBNBNBBCCNBCNCCN

NCNBCHB
BC
CH
CN
HB
NB
NC

B1 = 1
B2 = 2 1,5
C1 = 2
C2 = 2 2
H1 = 1
H2 = 1 1
N1 = 2
N2 = 1 1,5


*/
