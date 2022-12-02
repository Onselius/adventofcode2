package year21;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.ReadFile;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import org.json.simple.JSONArray;

public class Dec18 {

    private List<String> lines;
    private HashMap<List<Integer>, Integer> grid;

    public Dec18() {
    }

    protected long part1() throws ParseException
    {
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(lines.get(0));
        JSONArray secondArray;
        for (int i = 1; i < lines.size(); i++)
        {
            secondArray = (JSONArray) parser.parse(lines.get(i));
            array = add(array, secondArray);
            reduce(array);
            System.out.println(array);
            System.out.println();
        }
        System.out.println(array);
        return magnitude(array);
    }

    protected long part2()
    {
        return 0L;
    }

    public JSONArray explode(JSONArray array, int level)
    {
//        System.out.println("in array: " + array);
        if (level == 3)
        {
//            System.out.println("level: " + level + " array: " + array);
            JSONArray pair = null;
            int i = 0;
            for (; i < 2; i++)
            {
                if (array.get(i).getClass().equals(JSONArray.class))
                {
                    pair = (JSONArray) array.get(i);
//                    System.out.println("found pair: " + pair);
                    break;
                }
            }
            if (pair != null)
            {
                // Set value to 0;
                array.set(i, 0L);
                int otherIndex = (i + 1) % 2;
//                System.out.println(otherIndex);
                if (array.get(otherIndex).getClass().equals(Long.class))
                {
                    Long newValue = (long) pair.get(otherIndex) + (long) array.get(otherIndex);
                    array.set(otherIndex, newValue);
                    pair.set(otherIndex, 0L);
                    return pair;
                }
                Object node = array;
                while (!node.getClass().equals(Long.class))
                {
//                    System.out.println(((JSONArray) node).get(otherIndex));
                    if (((JSONArray) node).get(otherIndex).getClass().equals(JSONArray.class))
                    {
//                        System.out.println("goind down another array");
                        node = ((JSONArray) node).get(otherIndex);
                        continue;
                    }
//                    System.out.println("in array: " + node);
//                    System.out.println(node);
                    Long newValue = (long) pair.get(otherIndex) + (long) ((JSONArray) node).get(i);
                    ((JSONArray) node).set(i, newValue);
                    pair.set(otherIndex, 0L);
//                    System.out.println("new node: " + node);
                    break;
                }
            }
//            System.out.println("found pair: " + pair);
            return pair;
        }
        else
        {
            // Loop through and explode further
            for(int i = 0; i < 2; i++)
            {
                JSONArray pair;
                if (array.get(i).getClass().equals(JSONArray.class))
                {
//                    System.out.println("i: " + i + " value: " + array.get(i));
                    pair = explode((JSONArray) array.get(i), level + 1);
//                    System.out.println("i: " + i + " pair: " + pair);
                    if (pair != null)
                    {
                        int index = (pair.indexOf(0L) + 1) % 2;
                        if (index == i)
                        {
                            if (level != 0)
                            {
                                return pair;
                            }
                            else
                            {
                                return array;
                            }
                        }
                        if (array.get(index).getClass().equals(Long.class))
                        {
                            Long newValue = (long) pair.get(index) + (long) array.get(index);
                            array.set(index, newValue);
                            break;
                        }
//                        System.out.println(array.get(index).getClass());
//                        System.out.println(array);
                        JSONArray node = (JSONArray) array.get(index);
                        while (true)
                        {
//                            System.out.println(node);
//                            System.out.println(index);
//                            System.out.println(i);
                            if (node.get(i).getClass().equals(JSONArray.class))
                            {
                                node = (JSONArray) node.get(i);
                                continue;
                            }
                            Long newValue = (long) pair.get(index) + (long) node.get(i);
                            node.set(i, newValue);
                            break;
                        }
                    }
                }
            }
        }
//        System.out.println("returning array: " + array);
        return null;
    }

    public boolean split(JSONArray array)
    {
        boolean returnValue = false;
        for (int i = 0; i < 2; i++)
        {
            if (array.get(i).getClass().equals(Long.class))
            {
                if ((long) array.get(i) >= 10)
                {
                    long value = (long) array.get(i);
                    long first = value / 2;
                    long second = Math.round(value / 2.0);
                    JSONArray newArray = new JSONArray();
                    newArray.add(first);
                    newArray.add(second);
                    array.set(i, newArray);
                    return true;
                }
            }
            else
            {
                returnValue = split((JSONArray) array.get(i));
                if (returnValue)
                {
                    return true;
                }
            }
        }
        return returnValue;
    }

    public JSONArray add(JSONArray firstArray, JSONArray secondArray)
    {
        JSONArray newArray = new JSONArray();
        newArray.add(firstArray);
        newArray.add(secondArray);
        return newArray;
    }

    public JSONArray reduce(JSONArray array)
    {
        int hash = array.hashCode();
        while (true)
        {
            explode(array, 0);
            if (hash != array.hashCode())
            {
                hash = array.hashCode();
                continue;
            }
            if (split(array))
            {
                continue;
            }
            break;
        }
        return array;
    }

    public long magnitude(JSONArray array)
    {
        long sum = 0;
        for (int i = 0; i < 2; i++)
        {
            int product = i == 0 ? 3 : 2;
            if (array.get(i).getClass().equals(JSONArray.class))
            {
                sum += magnitude((JSONArray) array.get(i)) * product;
            }
            else
            {
                sum += (long) array.get(i) * product;
            }
        }
        return sum;
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
