package year21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Dec10Test {
    private final Dec10 dec10 = new Dec10();
    private final String testFilename = "test/test10.txt";
    private final String inputFilename = "input/input10.txt";

    @Test
    void testPart1()
    {
        dec10.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(5, dec10.part1());
    }

    @Test
    void testPart2()
    {
        dec10.updateLinesFromFilename(testFilename);

        Assertions.assertEquals(12, dec10.part2());
    }

    @Test
    void testPart1Input()
    {
        dec10.updateLinesFromFilename(inputFilename);

        long answer = dec10.part1();
        System.out.println("Part1: " + answer);
        Assertions.assertEquals(6461, answer);
    }

    @Test
    void testPart2Input()
    {
        dec10.updateLinesFromFilename(inputFilename);

        long answer = dec10.part2();
        System.out.println("Part2: " + answer);
        Assertions.assertEquals(18105, answer);
    }
}