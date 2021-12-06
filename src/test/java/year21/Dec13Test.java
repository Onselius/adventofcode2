package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec13Test {
    private final Dec13 dec13 = new Dec13();
    private final String testFilename = "test/test13.txt";
    private final String inputFilename = "input/input13.txt";

    @Test
    void testPart1()
    {
        dec13.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec13.part1());
    }

    @Test
    void testPart2()
    {
        dec13.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec13.part2());
    }

    @Test
    void testPart1Input()
    {
        dec13.updateLinesFromFilename(inputFilename);

        long answer = dec13.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec13.updateLinesFromFilename(inputFilename);

        long answer = dec13.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18135, answer);
    }
}