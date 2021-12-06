package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec16Test {
    private final Dec16 dec16 = new Dec16();
    private final String testFilename = "test/test16.txt";
    private final String inputFilename = "input/input16.txt";

    @Test
    void testPart1()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec16.part1());
    }

    @Test
    void testPart2()
    {
        dec16.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec16.part2());
    }

    @Test
    void testPart1Input()
    {
        dec16.updateLinesFromFilename(inputFilename);

        long answer = dec16.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec16.updateLinesFromFilename(inputFilename);

        long answer = dec16.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18165, answer);
    }
}