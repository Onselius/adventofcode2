package year21;

import util.ReadFile;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dec12 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;

    public Dec12() {
    }

    protected long part1()
    {
        return 0L;
    }

    protected long part2()
    {
        return 0L;
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
