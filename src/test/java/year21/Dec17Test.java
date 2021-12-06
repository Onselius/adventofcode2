package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec17Test {
    private final Dec17 dec17 = new Dec17();
    private final String testFilename = "test/test17.txt";
    private final String inputFilename = "input/input17.txt";

    @Test
    void testPart1()
    {
        dec17.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec17.part1());
    }

    @Test
    void testPart2()
    {
        dec17.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec17.part2());
    }

    @Test
    void testPart1Input()
    {
        dec17.updateLinesFromFilename(inputFilename);

        long answer = dec17.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec17.updateLinesFromFilename(inputFilename);

        long answer = dec17.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18175, answer);
    }
}