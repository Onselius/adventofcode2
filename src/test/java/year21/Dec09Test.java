package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec09Test {
    private final Dec09 dec09 = new Dec09();
    private final String testFilename = "test/test09.txt";
    private final String inputFilename = "input/input09.txt";

    @Test
    void testPart1()
    {
        dec09.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec09.part1());
    }

    @Test
    void testPart2()
    {
        dec09.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec09.part2());
    }

    @Test
    void testPart1Input()
    {
        dec09.updateLinesFromFilename(inputFilename);

        long answer = dec09.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec09.updateLinesFromFilename(inputFilename);

        long answer = dec09.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18095, answer);
    }
}