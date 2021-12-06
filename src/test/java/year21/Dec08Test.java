package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec08Test {
    private final Dec08 dec08 = new Dec08();
    private final String testFilename = "test/test08.txt";
    private final String inputFilename = "input/input08.txt";

    @Test
    void testPart1()
    {
        dec08.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec08.part1());
    }

    @Test
    void testPart2()
    {
        dec08.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec08.part2());
    }

    @Test
    void testPart1Input()
    {
        dec08.updateLinesFromFilename(inputFilename);

        long answer = dec08.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec08.updateLinesFromFilename(inputFilename);

        long answer = dec08.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18085, answer);
    }
}