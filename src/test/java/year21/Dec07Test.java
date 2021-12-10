package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec07Test {
    private final Dec07 dec07 = new Dec07();
    private final String testFilename = "test/test07.txt";
    private final String inputFilename = "input/input07.txt";

    @Test
    void testPart1()
    {
        dec07.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(37, dec07.part1());
    }

    @Test
    void testPart2()
    {
        dec07.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(168, dec07.part2());
    }

    @Test
    void testPart1Input()
    {
        dec07.updateLinesFromFilename(inputFilename);

        long answer = dec07.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(328187, answer);
    }

    @Test
    void testPart2Input()
    {
        dec07.updateLinesFromFilename(inputFilename);

        long answer = dec07.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(91257582, answer);
    }
}