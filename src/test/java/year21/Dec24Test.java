package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec24Test {
    private final Dec24 dec24 = new Dec24();
    private final String testFilename = "test/test24.txt";
    private final String inputFilename = "input/input24.txt";

    @Test
    void testPart1()
    {
        dec24.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec24.part1());
    }

    @Test
    void testPart2()
    {
        dec24.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec24.part2());
    }

    @Test
    void testPart1Input()
    {
        dec24.updateLinesFromFilename(inputFilename);

        long answer = dec24.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec24.updateLinesFromFilename(inputFilename);

        long answer = dec24.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18245, answer);
    }
}