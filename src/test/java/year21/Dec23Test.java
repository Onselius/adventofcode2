package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec23Test {
    private final Dec23 dec23 = new Dec23();
    private final String testFilename = "test/test23.txt";
    private final String inputFilename = "input/input23.txt";

    @Test
    void testPart1()
    {
        dec23.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec23.part1());
    }

    @Test
    void testPart2()
    {
        dec23.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec23.part2());
    }

    @Test
    void testPart1Input()
    {
        dec23.updateLinesFromFilename(inputFilename);

        long answer = dec23.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec23.updateLinesFromFilename(inputFilename);

        long answer = dec23.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18235, answer);
    }
}