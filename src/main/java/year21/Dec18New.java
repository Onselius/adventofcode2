package year21;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.ReadFile;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dec18New {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;

    public Dec18New() {
    }

    protected long part1() throws ParseException
    {
        return 0L;
    }

    protected long part2()
    {
        return 0L;
    }

    public String explode(String string)
    {
        Pattern pattern = Pattern.compile("\\[.*\\[.*\\[.*\\[.*(\\[\\d,\\d]).*");
        Matcher matcher = pattern.matcher(string);
        boolean found = matcher.find();
        if (found)
        {
            String match = matcher.group(1);
            System.out.println(matcher.groupCount());
            System.out.println(match);
            System.out.println(matcher.start(1));
        }



        return "";
    }

    public String split(String string)
    {
        return "";
    }

    public String add(String first, String second)
    {
        return "";
    }

    public long magnitude(String string)
    {
        return 0L;
    }

    public void updateLinesFromFilename(String filename)
    {
        URL url  = getClass().getResource(filename);
        this.lines = ReadFile.getTextFromFile(url.getPath());
    }
}
