package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec12Test {
    private final Dec12 dec12 = new Dec12();
    private final String testFilename = "test/test12.txt";
    private final String inputFilename = "input/input12.txt";

    @Test
    void testPart1()
    {
        dec12.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec12.part1());
    }

    @Test
    void testPart2()
    {
        dec12.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec12.part2());
    }

    @Test
    void testPart1Input()
    {
        dec12.updateLinesFromFilename(inputFilename);

        long answer = dec12.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec12.updateLinesFromFilename(inputFilename);

        long answer = dec12.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18125, answer);
    }
}