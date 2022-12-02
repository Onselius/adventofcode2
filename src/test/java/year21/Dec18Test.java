package year21;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec18Test {
    private final Dec18 dec18 = new Dec18();
    private final String testFilename = "test/test18.txt";
    private final String inputFilename = "input/input18.txt";

    @Test
    void testPart1() throws ParseException {
        dec18.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(4140, dec18.part1());
    }

    @Test
    void test()
    {
        for (int i = 0; i < 2; i++)
        {
            System.out.println("i: " + i + " other: " + ((i + 1) % 2));
        }
        System.out.println(0 % 2);
        System.out.println(1 % 2);
        System.out.println(2 % 2);
    }

    @Test
    void testExplode1() throws ParseException {
        String inputString = "[[6,[5,[4,[3,2]]]],1]";
        JSONParser parser = new JSONParser();
        JSONArray inputArray = (JSONArray) parser.parse(inputString);

        dec18.explode(inputArray, 0);

        String expectedString = "[[6,[5,[7,0]]],3]";
        JSONArray expectedArray = (JSONArray) parser.parse(expectedString);
        Assertions.assertEquals(expectedArray, inputArray);
    }

    @Test
    void testExplode2() throws ParseException {
        String inputString = "[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]";
        JSONParser parser = new JSONParser();
        JSONArray inputArray = (JSONArray) parser.parse(inputString);

        dec18.explode(inputArray, 0);

        String expectedString = "[[3,[2,[8,0]]],[9,[5,[7,0]]]]";
        JSONArray expectedArray = (JSONArray) parser.parse(expectedString);
        Assertions.assertEquals(expectedArray, inputArray);
    }

    @Test
    void testExplode3() throws ParseException {
        String inputString = "[[[[0,7],4],[7,[[8,4],9]]],[1,1]]";
        JSONParser parser = new JSONParser();
        JSONArray inputArray = (JSONArray) parser.parse(inputString);

        dec18.explode(inputArray, 0);

        String expectedString = "[[[[0,7],4],[15,[0,13]]],[1,1]]";
        JSONArray expectedArray = (JSONArray) parser.parse(expectedString);
        Assertions.assertEquals(expectedArray, inputArray);
    }

    @Test
    void testSplit() throws ParseException {
        String inputString = "[[[[0,7],4],[15,[0,13]]],[1,1]]";
        JSONParser parser = new JSONParser();
        String expectedString = "[[[[0,7],4],[[7,8],[0,13]]],[1,1]]";
        JSONArray actual = (JSONArray) parser.parse(inputString);
        JSONArray expected = (JSONArray) parser.parse(expectedString);


        Assertions.assertTrue(dec18.split(actual));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMagnitude() throws ParseException {
        String inputString = "[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]";
        JSONParser parser = new JSONParser();
        JSONArray inputArray = (JSONArray) parser.parse(inputString);

        Assertions.assertEquals(3488, dec18.magnitude(inputArray));
    }

    @Test
    void testAddition() throws ParseException
    {
        String inputString = "[[[[4,3],4],4],[7,[[8,4],9]]]";
        String secondString = "[1,1]";
        JSONParser parser = new JSONParser();
        JSONArray inputArray = (JSONArray) parser.parse(inputString);
        JSONArray secondArray = (JSONArray) parser.parse(secondString);
        String expectedString = "[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]";
        JSONArray expectedArray = (JSONArray) parser.parse(expectedString);

        Assertions.assertEquals(expectedArray, dec18.add(inputArray, secondArray));
    }

    @Test
    void testReduce() throws ParseException
    {
        String inputString = "[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]";
        JSONParser parser = new JSONParser();
        JSONArray inputArray = (JSONArray) parser.parse(inputString);
        String expectedString = "[[[[0,7],4],[[7,8],[6,0]]],[8,1]]";
        JSONArray expectedArray = (JSONArray) parser.parse(expectedString);

        Assertions.assertEquals(expectedArray, dec18.reduce(inputArray));
    }

    @Test
    void testPart2()
    {
        dec18.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec18.part2());
    }

    @Test
    void testPart1Input() throws ParseException {
        dec18.updateLinesFromFilename(inputFilename);

        long answer = dec18.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec18.updateLinesFromFilename(inputFilename);

        long answer = dec18.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18185, answer);
    }
}