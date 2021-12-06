package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec25Test {
    private final Dec25 dec25 = new Dec25();
    private final String testFilename = "test/test25.txt";
    private final String inputFilename = "input/input25.txt";

    @Test
    void testPart1()
    {
        dec25.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec25.part1());
    }

    @Test
    void testPart2()
    {
        dec25.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec25.part2());
    }

    @Test
    void testPart1Input()
    {
        dec25.updateLinesFromFilename(inputFilename);

        long answer = dec25.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec25.updateLinesFromFilename(inputFilename);

        long answer = dec25.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18255, answer);
    }
}