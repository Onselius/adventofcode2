package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec19Test {
    private final Dec19 dec19 = new Dec19();
    private final String testFilename = "test/test19.txt";
    private final String inputFilename = "input/input19.txt";

    @Test
    void testPart1()
    {
        dec19.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec19.part1());
    }

    @Test
    void testPart2()
    {
        dec19.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec19.part2());
    }

    @Test
    void testPart1Input()
    {
        dec19.updateLinesFromFilename(inputFilename);

        long answer = dec19.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec19.updateLinesFromFilename(inputFilename);

        long answer = dec19.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18195, answer);
    }
}