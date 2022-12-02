package year21;

import util.ReadFile;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Dec12 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;
    private int paths;
    private HashMap<String, List<String>> connections;

    public Dec12() {
        this.paths = 0;
    }

    protected long part1()
    {
        this.connections = parseInput();

        ArrayList<String> path = new ArrayList<>();
        traverse("start", path);

        return paths;
    }

    protected long part2()
    {
        this.connections = parseInput();

        ArrayList<String> path = new ArrayList<>();
        traverse2("start", path, false);

        return paths;
    }

    private HashMap<String, List<String>> parseInput()
    {
        HashMap<String, List<String>> connections = new HashMap<>();
        for (String line : lines)
        {
            String[] splitted = line.split("-");
            connections.putIfAbsent(splitted[0], new ArrayList<>());
            connections.putIfAbsent(splitted[1], new ArrayList<>());

            connections.get(splitted[0]).add(splitted[1]);
            connections.get(splitted[1]).add(splitted[0]);
        }

        return connections;
    }

    private void traverse(
            String node,
            ArrayList<String> path)
    {
        path.add(node);
        for (String child : this.connections.get(node))
        {
            if (child.equals("end"))
            {
                this.paths++;
                continue;
            }
            if (child.equals(child.toLowerCase()) && path.contains(child))
            {
                continue;
            }
            ArrayList<String> childPath = (ArrayList<String>) path.clone();
            traverse(child, childPath);
        }
    }

    private void traverse2(
            String node,
            ArrayList<String> path,
            boolean hasVisitedSmall)
    {
        path.add(node);
        for (String child : this.connections.get(node))
        {
            if (child.equals("start")) continue;
            if (child.equals("end"))
            {
                this.paths++;
                continue;
            }
            boolean isLowerCase = child.equals(child.toLowerCase());
            boolean newCheckForSmall = hasVisitedSmall;
            if (isLowerCase && hasVisitedSmall && path.contains(child))
            {
                continue;
            }
            if (isLowerCase && path.contains(child))
            {
                newCheckForSmall = true;
            }
            ArrayList<String> childPath = (ArrayList<String>) path.clone();
            traverse2(child, childPath, newCheckForSmall);
        }
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
