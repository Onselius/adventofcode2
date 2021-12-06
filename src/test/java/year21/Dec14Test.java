package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec14Test {
    private final Dec14 dec14 = new Dec14();
    private final String testFilename = "test/test14.txt";
    private final String inputFilename = "input/input14.txt";

    @Test
    void testPart1()
    {
        dec14.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec14.part1());
    }

    @Test
    void testPart2()
    {
        dec14.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec14.part2());
    }

    @Test
    void testPart1Input()
    {
        dec14.updateLinesFromFilename(inputFilename);

        long answer = dec14.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec14.updateLinesFromFilename(inputFilename);

        long answer = dec14.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18145, answer);
    }
}