package year21;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Dec18NewTest {
    private final Dec18New dec18 = new Dec18New();
    private final String testFilename = "test/test18.txt";
    private final String inputFilename = "input/input18.txt";

    @Test
    void testPart1() throws ParseException {
        dec18.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(4140, dec18.part1());
    }

    @Test
    void testExplode()
    {
        String stringToTest = "[[[[[9,8],1],2],3],4]";
        stringToTest = "[7,[6,[5,[4,[3,2]]]]]";
        stringToTest = "[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]";
        dec18.explode(stringToTest);
    }

}